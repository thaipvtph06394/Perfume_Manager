package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.adapter.ProductAdapter;
import vn.edu.poly.perfume_manager.model.Bill;

public class BillActivity extends AppCompatActivity {
    private Toolbar toolbarBill;
    RecyclerView rvBill;
    private List<Bill> listBill;
//    private BillAdapter adapterBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        toolbarBill = findViewById(R.id.toolbarBill);
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

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbarBill, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);


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

    public void onAddBill(View view) {
    }
}
