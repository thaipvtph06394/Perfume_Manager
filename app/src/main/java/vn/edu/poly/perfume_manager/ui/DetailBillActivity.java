package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vn.edu.poly.perfume_manager.R;

public class DetailBillActivity extends AppCompatActivity {
    Toolbar toolbarDetailBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bill);

        toolbarDetailBill = findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbarDetailBill);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarDetailBill.setTitleTextColor(Color.WHITE);
        toolbarDetailBill.setTitle("Hóa Đơn chi tiết");
        toolbarDetailBill.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarDetailBill.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
