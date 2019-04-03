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

public class ProductIDSninnerAdapter extends BaseAdapter {
    public Context context;
    public List<Product> products;

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {

        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.product_id_spninner,parent,false);
        TextView tvName;
        tvName = convertView.findViewById(R.id.tvNameProductId);
        tvName.setText(position + "|" + products.get(position).product_id);
        return convertView;
    }
}
