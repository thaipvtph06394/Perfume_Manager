package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.adapter.TopProductAdapter;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.model.SelectTopProduct;
import vn.edu.poly.perfume_manager.sqlitedao.ProductDAO;

public class TopActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<SelectTopProduct> productList;
    private TopProductAdapter adapter;
    private DatabaseHelper databaseHelper;
    private ProductDAO productDAO;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        toolbar = findViewById(R.id.toolbarTop);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Top sản phẩm");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        databaseHelper = new DatabaseHelper(this);
        productDAO = new ProductDAO(databaseHelper);

        recyclerView = findViewById(R.id.rv_top);
        productList = productDAO.getTop();
        adapter = new TopProductAdapter(productList);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }
}
