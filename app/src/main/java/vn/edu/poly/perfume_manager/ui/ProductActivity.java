package vn.edu.poly.perfume_manager.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.listener.OnDelete;
import vn.edu.poly.perfume_manager.listener.OnEdit;
import vn.edu.poly.perfume_manager.listener.OnViewProduct;
import vn.edu.poly.perfume_manager.model.Bill;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.sqlitedao.ProductDAO;
import vn.edu.poly.perfume_manager.ui.AddProductActivity;
import vn.edu.poly.perfume_manager.adapter.ProductAdapter;

import static android.os.Build.VERSION_CODES.O;

public class ProductActivity extends AppCompatActivity implements OnDelete, OnEdit<Product>, OnViewProduct {
    Toolbar toolbarProduct;
    private List<Product> listProduct;
    private ProductAdapter adapterProduct;
    private RecyclerView rvProduct;
    private FloatingActionButton fbtnProduct;
    private DatabaseHelper databaseHelper;
    private ProductDAO productDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initViews();

        databaseHelper = new DatabaseHelper(this);
        productDAO = new ProductDAO(databaseHelper);
        listProduct = new ArrayList<>();

        setData();
        
        fbtnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity.this,AddProductActivity.class));
            }
        });

    }

    private void initViews() {
        toolbarProduct =findViewById(R.id.toolbarProduct);
        rvProduct =  findViewById(R.id.rvProduct);
        fbtnProduct = findViewById(R.id.fbtn_Product);

        setSupportActionBar(toolbarProduct);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarProduct.setTitleTextColor(Color.WHITE);
        toolbarProduct.setTitle(getString(R.string.product_title));
        toolbarProduct.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbarProduct.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


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
                showDialogSearch();
                break;
        }
        return false;
    }

    private void showDialogSearch() {

    }



    @Override
    public void OnDelete(final String id, final int posion) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Bạn có muốn xóa sản phẩm này không?");
        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                productDAO.deleteProduct(id);
                listProduct.remove(posion);
                adapterProduct.notifyDataSetChanged();
                setData();
                Toast.makeText(ProductActivity.this, "Xóa thành công !", Toast.LENGTH_SHORT).show();
            }


        });
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    @Override
    public void OnEdit(Product product) {

    }


    @Override
    public void OnViewProduct(Product product) {
        startActivity(new Intent(getApplicationContext(),DetailProduct.class));

    }
    private void setData() {
        listProduct = productDAO.getAllProducts();
        adapterProduct = new ProductAdapter(listProduct,this,this,this);
        rvProduct.setAdapter(adapterProduct);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvProduct.setLayoutManager(manager);
    }
}
