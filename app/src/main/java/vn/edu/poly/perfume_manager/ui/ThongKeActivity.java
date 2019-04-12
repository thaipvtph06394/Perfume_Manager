package vn.edu.poly.perfume_manager.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Map;

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
        toolbarThongke.setTitle("Thống kê");
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
        ArrayList<BarEntry> barEntries =new ArrayList<>();
        for (int i=0;i<data;i++){
            float value = (float) (Math.random()*1000);
            barEntries.add(new BarEntry(i,(int) value));
        }
        BarDataSet set = new BarDataSet(barEntries, "Data Set");
        set.setColors(ColorTemplate.LIBERTY_COLORS);
        set.setDrawIcons(true);

        BarData datas = new BarData(set);
        bcThongKe.setData(datas);
        bcThongKe.invalidate();
        bcThongKe.animateY(2000);
    }
}
