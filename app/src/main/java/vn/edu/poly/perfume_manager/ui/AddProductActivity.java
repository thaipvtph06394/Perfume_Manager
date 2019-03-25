package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vn.edu.poly.perfume_manager.R;

public class AddProductActivity extends AppCompatActivity {

    private Toolbar toolbarAddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        toolbarAddProduct = findViewById(R.id.toolbarAddProduct);
        setSupportActionBar(toolbarAddProduct);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarAddProduct.setTitleTextColor(Color.WHITE);
        toolbarAddProduct.setTitle("Thêm hóa sản phẩm");
        toolbarAddProduct.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarAddProduct.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
