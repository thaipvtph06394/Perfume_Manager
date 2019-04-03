package vn.edu.poly.perfume_manager.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.ui.AddProductActivity;
import vn.edu.poly.perfume_manager.adapter.ProductAdapter;

public class ProductActivity extends AppCompatActivity {
    Toolbar toolbarProduct;
    FloatingActionButton floatingActionButton;
    RecyclerView rvBill;
    private List<Product> listProduct;
    private ProductAdapter adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        toolbarProduct = findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbarProduct);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarProduct.setTitleTextColor(Color.WHITE);
        toolbarProduct.setTitle("Sản Phẩm");
        toolbarProduct.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarProduct.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void onAddProduct(View view) {
        startActivity(new Intent(getApplicationContext(),AddProductActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.timkiem_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_item:

                break;
        }
        return false;
    }
}
