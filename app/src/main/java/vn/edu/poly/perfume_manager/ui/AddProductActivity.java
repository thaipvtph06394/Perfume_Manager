package vn.edu.poly.perfume_manager.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.adapter.ProductAdapter;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.listener.OnDelete;
import vn.edu.poly.perfume_manager.listener.OnEdit;
import vn.edu.poly.perfume_manager.listener.OnViewProduct;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.sqlitedao.ProductDAO;

public class AddProductActivity extends AppCompatActivity {

    private Toolbar toolbarAddProduct;
    private EditText edProductName;
    private EditText edProductId;
    private EditText edProductBrand;
    private EditText edProductMade;
    private EditText edProductPriceIn;
    private EditText edProductPriceOut;
    private EditText edProductQuality;

    private EditText edProductDetail;
    private Button btnProductCreate;
    private Button btnProductCancel;

    private DatabaseHelper databaseHelper;
    private ProductDAO productDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        initViews();
        toolbarViews();
        databaseHelper = new DatabaseHelper(this);
        productDAO = new ProductDAO(databaseHelper);

        btnProductCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();

                product.product_name = edProductName.getText().toString().trim();
                product.product_id = edProductId.getText().toString().trim();
                product.product_brand= edProductBrand.getText().toString().trim();
                product.product_detail = edProductDetail.getText().toString().trim();
                product.product_made = edProductMade.getText().toString().trim();

                if(product.product_name.isEmpty()){
                    edProductName.setError("Không được để trống!");
                    return;
                }else if(product.product_id.isEmpty()){
                    edProductId.setError("Không được để trống!");
                    return;
                }else if(product.product_id.length() !=5){
                    edProductId.setError("Mã sản phẩm phải nhập 5 ký tự");
                    return;
                }else if(product.product_name.length()<6){
                    edProductId.setError("Ký tự phải lớn hơn 6");
                    return;
                }
                else if(product.product_brand.isEmpty()){
                    edProductBrand.setError("Không được để trống!");
                    return;
                }
                else if(product.product_made.isEmpty()){
                    edProductMade.setError("Không được để trống!");
                    return;
                }
                else if(product.product_detail.isEmpty()){
                    edProductDetail.setError("Không được để trống!");
                    return;
                }
                try {
                    product.product_price_out = Long.parseLong(edProductPriceOut.getText().toString().trim());

                }catch (NumberFormatException ex){
                    edProductPriceOut.setError("Giá xuất phải là số");
                }
                try {
                    product.product_price_in = Long.parseLong(edProductPriceIn.getText().toString().trim());

                }catch (NumberFormatException ex){
                    edProductPriceIn.setError("Giá nhập phải là số");
                }
                try {
                    product.product_quality = Integer.parseInt(edProductQuality.getText().toString().trim());
                }catch (NumberFormatException ex){
                    edProductQuality.setError("Số lượng phải là số");
                }

                if (productDAO.insertProduct(product)>0){

                    Toast.makeText(getApplicationContext(), "Thêm sản phẩm thành công!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),ProductActivity.class));


                }else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại!", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnProductCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edProductName.setText("");
                edProductId.setText("");
                edProductBrand.setText("");
                edProductMade.setText("");
                edProductPriceIn.setText("");
                edProductPriceOut.setText("");
                edProductQuality.setText("");
                edProductDetail.setText("");
            }
        });

    }

    private void toolbarViews() {
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

    private void validateFrom() {
        Product product = new Product();

       product.product_name = edProductName.getText().toString().trim();
       product.product_id = edProductId.getText().toString().trim();
       product.product_brand= edProductBrand.getText().toString().trim();
       product.product_detail = edProductDetail.getText().toString().trim();
       product.product_made = edProductMade.getText().toString().trim();

       if(product.product_name.isEmpty()){
           edProductName.setError("Không được để trống!");

       }else if(product.product_id.isEmpty()){
            edProductId.setError("Không được để trống!");

        }else if(product.product_id.length()<6){
            edProductId.setError("Ký tự phải lớn hơn 6");

        }
        else if(product.product_brand.isEmpty()){
            edProductBrand.setError("Không được để trống!");

        }
        else if(product.product_made.isEmpty()){
            edProductMade.setError("Không được để trống!");

        }
        else if(product.product_detail.isEmpty()){
            edProductDetail.setError("Không được để trống!");

        }

        try {
            product.product_price_out = Long.parseLong(edProductPriceOut.getText().toString().trim());

        }catch (NumberFormatException ex){
             edProductPriceOut.setError("Giá phải là số");
        }
        try {
            product.product_price_in = Long.parseLong(edProductPriceIn.getText().toString().trim());

        }catch (NumberFormatException ex){
            edProductPriceIn.setError("Giá phải là số");
        }
        try {
            product.product_quality = Integer.parseInt(edProductQuality.getText().toString().trim());
        }catch (NumberFormatException ex){
            edProductQuality.setError("Số lượng phải là số");
        }
        long result = productDAO.insertProduct(product);
        if (result>0){

            productDAO.insertProduct(product);
            Toast.makeText(getApplicationContext(), "Thêm sản phẩm thành công!", Toast.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(getApplicationContext(),ProductActivity.class));
        }else {
            Toast.makeText(getApplicationContext(), "Thêm thất bại!", Toast.LENGTH_LONG).show();
        }



    }

    private void initViews() {


        edProductName =  findViewById(R.id.edProduct_Name);
        edProductId =  findViewById(R.id.edProduct_id);
        edProductBrand =  findViewById(R.id.edProduct_brand);
        edProductMade =  findViewById(R.id.edProduct_made);
        edProductPriceIn =  findViewById(R.id.edProduct_price_in);
        edProductPriceOut = findViewById(R.id.edProduct_Price_out);
        edProductQuality =  findViewById(R.id.edProduct_quality);

        edProductDetail =  findViewById(R.id.edProduct_Detail);
        btnProductCreate =  findViewById(R.id.btnProduct_Create);
        btnProductCancel =  findViewById(R.id.btnProduct_Cancel);

        toolbarAddProduct = findViewById(R.id.toolbarAddProduct);

    }

}
