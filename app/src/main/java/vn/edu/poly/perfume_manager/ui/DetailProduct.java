package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vn.edu.poly.perfume_manager.R;

public class DetailProduct extends AppCompatActivity {
    Toolbar toolbarDetailProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        toolbarDetailProduct = findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbarDetailProduct);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarDetailProduct.setTitleTextColor(Color.WHITE);
        toolbarDetailProduct.setTitle("Sản phẩm chi tiết");
        toolbarDetailProduct.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarDetailProduct.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
