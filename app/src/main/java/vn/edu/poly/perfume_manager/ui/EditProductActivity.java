package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.model.Bill;
import vn.edu.poly.perfume_manager.model.Product;

public class EditProductActivity extends AppCompatActivity {
    private Toolbar toolbarAddProduct;
    private EditText edProductName;
    private EditText edProductBrand;
    private EditText edProductMade;
    private EditText edProductPriceIn;
    private EditText edProductPriceOut;
    private EditText edProductQuality;
    private EditText edProductDetail;
    private Button btnProductEdit;
    private Button btnProductCancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        toolbarAddProduct = findViewById(R.id.toolbarAddProduct);
        setSupportActionBar(toolbarAddProduct);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarAddProduct.setTitleTextColor(Color.WHITE);
        toolbarAddProduct.setTitle("Sửa sản phẩm");
        editViews();
        initViews();
        btnProductCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnProductEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void editViews() {
        Product product = new Product();
        product.product_name = edProductName.getText().toString().trim();

    }

    private void initViews() {
        toolbarAddProduct = (Toolbar) findViewById(R.id.toolbarAddProduct);
        edProductName = (EditText) findViewById(R.id.edProduct_Name);
        edProductBrand = (EditText) findViewById(R.id.edProduct_brand);
        edProductMade = (EditText) findViewById(R.id.edProduct_made);
        edProductPriceIn = (EditText) findViewById(R.id.edProduct_price_in);
        edProductPriceOut = (EditText) findViewById(R.id.edProduct_Price_out);
        edProductQuality = (EditText) findViewById(R.id.edProduct_quality);
        edProductDetail = (EditText) findViewById(R.id.edProduct_Detail);
        btnProductEdit = (Button) findViewById(R.id.btnProduct_Edit);
        btnProductCancel = (Button) findViewById(R.id.btnProduct_Cancel);
    }
}
