package vn.edu.poly.perfume_manager.ui.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.ui.BillActivity;
import vn.edu.poly.perfume_manager.ui.ProductActivity;
import vn.edu.poly.perfume_manager.ui.ThongKeActivity;
import vn.edu.poly.perfume_manager.ui.TinTucActivity;
import vn.edu.poly.perfume_manager.ui.TopActivity;
import vn.edu.poly.perfume_manager.ui.UserActivity;

public class FragmentHomeActivity extends Fragment {
    private LinearLayout User;
    private LinearLayout Perfume;
    private LinearLayout tintuc;
    private LinearLayout bill;
    private LinearLayout thongke;
    private LinearLayout top;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_home,container,false);



        User = (LinearLayout) view.findViewById(R.id.User);
        Perfume = (LinearLayout) view.findViewById(R.id.Perfume);
        tintuc = (LinearLayout) view.findViewById(R.id.tintuc);
        bill = (LinearLayout) view.findViewById(R.id.bill);
        thongke = (LinearLayout) view.findViewById(R.id.thongke);
        top = (LinearLayout) view.findViewById(R.id.top);

        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),UserActivity.class));
            }
        });
        Perfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ProductActivity.class));
            }
        });
        tintuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TinTucActivity.class));
            }
        });
        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),BillActivity.class));
            }
        });
        thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ThongKeActivity.class));
            }
        });
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TopActivity.class));
            }
        });
        return view;


    }
}
