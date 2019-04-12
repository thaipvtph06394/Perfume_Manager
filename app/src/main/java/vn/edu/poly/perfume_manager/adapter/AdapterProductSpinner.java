package vn.edu.poly.perfume_manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.model.Product;

public class AdapterProductSpinner extends BaseAdapter {


    public Context context;
    public List<Product> products;

    public AdapterProductSpinner(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.type_book_spinner, viewGroup, false);
        TextView tvName;
        tvName = view.findViewById(R.id.tvName);
        tvName.setText(i + " | " + products.get(i).product_name);
        return view;
    }

}
