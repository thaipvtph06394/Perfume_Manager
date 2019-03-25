package vn.edu.poly.perfume_manager.ui.fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.model.Bill;
import vn.edu.poly.perfume_manager.ui.adapter.BillAdapter;

public class BillActivity extends AppCompatActivity{
    Toolbar toolbarBill;
    RecyclerView rvBill;
    private List<Bill> listBill;
    private BillAdapter adapterBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        toolbarBill = findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbarBill);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarBill.setTitleTextColor(Color.WHITE);
        toolbarBill.setTitle("Hóa Đơn");
        toolbarBill.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarBill.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
