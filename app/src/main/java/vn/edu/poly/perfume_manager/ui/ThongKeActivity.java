package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;

import vn.edu.poly.perfume_manager.R;

public class ThongKeActivity extends AppCompatActivity {
    private BarChart bcThongKe;
    private Toolbar toolbarThongke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        toolbarThongke = findViewById(R.id.toolbarThongke);
        setSupportActionBar(toolbarThongke);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarThongke.setTitleTextColor(Color.WHITE);
        toolbarThongke.setTitle("Chia sẻ App");
        toolbarThongke.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarThongke.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        bcThongKe = (BarChart) findViewById(R.id.bcThongKe);
        bcThongKe.getDescription().setEnabled(false);
        setData(12);
        bcThongKe.setFitBars(true);

    }

    public void setData(int data) {
//        this.data = data;
    }
}
