package vn.edu.poly.perfume_manager.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.perfume_manager.Constant;
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

public class ProductActivity extends AppCompatActivity implements OnDelete, OnEdit, OnViewProduct , Constant {
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
    public void OnEdit(String id, int posion) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_edit_product, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        final EditText edProductName;
        final EditText edProductBrand;
        final EditText edProductMade;
        final EditText edProductPriceIn;
        final EditText edProductPriceOut;
        final EditText edProductQuality;
        final EditText edProductDetail;
        Button btnProductEdit;
        Button btnProductCancel;

        edProductName = (EditText) dialogView.findViewById(R.id.edProduct_Name);
        edProductBrand = (EditText) dialogView.findViewById(R.id.edProduct_brand);
        edProductMade = (EditText) dialogView.findViewById(R.id.edProduct_made);
        edProductPriceIn = (EditText) dialogView.findViewById(R.id.edProduct_price_in);
        edProductPriceOut = (EditText) dialogView.findViewById(R.id.edProduct_Price_out);
        edProductQuality = (EditText) dialogView.findViewById(R.id.edProduct_quality);
        edProductDetail = (EditText) dialogView.findViewById(R.id.edProduct_Detail);
        btnProductEdit = (Button) dialogView.findViewById(R.id.btnProduct_Edit);
        btnProductCancel = (Button) dialogView.findViewById(R.id.btnProduct_Cancel);
        Product product = listProduct.get(posion);
        edProductName.setText(product.product_name);
        edProductBrand.setText(product.product_brand);
        edProductDetail.setText(product.product_detail);
        edProductMade.setText(product.product_made);
        edProductPriceIn.setText((int) product.product_price_in);
        edProductPriceOut.setText((int) product.product_price_out);
        edProductQuality.setText(product.product_quality);

        btnProductCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
        btnProductEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();

                product.product_name = edProductName.getText().toString().trim();
                product.product_brand= edProductBrand.getText().toString().trim();
                product.product_detail = edProductDetail.getText().toString().trim();
                product.product_made = edProductMade.getText().toString().trim();

                if(product.product_name.isEmpty()){
                    edProductName.setError("Không được để trống!");
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

                if (productDAO.updateProduct(product)>0){

                    productDAO.insertProduct(product);
                    adapterProduct.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Chỉnh sửa thành công!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),ProductActivity.class));
                    dialog1.dismiss();

                }else {
                    Toast.makeText(getApplicationContext(), "Sửa thất bại thất bại!", Toast.LENGTH_LONG).show();
                }

            }

        });


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
