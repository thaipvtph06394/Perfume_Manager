package vn.edu.poly.perfume_manager.ui.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;

import vn.edu.poly.perfume_manager.R;

public class FragmentHomeActivity extends Fragment {
    private BarChart bcThongKe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_home,container,false);

        bcThongKe = (BarChart) view.findViewById(R.id.bcThongKe);
        bcThongKe.getDescription().setEnabled(false);

        setData(12);
        bcThongKe.setFitBars(true);
        return view;
    }

    public void setData(int count) {
//        ArrayList<BarChart> list = new ArrayList<>();
//        for (int i = 0;i < count; i++){
//            float value = (float)(Math.random()*100);
//            list.add(new BarChart(i,(int) value));
//        }
//        BarChart
    }
}
