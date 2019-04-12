package vn.edu.poly.perfume_manager.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.model.SelectTopProduct;

public class TopProductAdapter extends RecyclerView.Adapter<TopProductAdapter.ViewHolder> {
    private List<SelectTopProduct> productsList;

    public TopProductAdapter(List<SelectTopProduct> products) {
        this.productsList = products;
    }

    @NonNull
    @Override
    public TopProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_top,parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TopProductAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgAvt;
        public TextView tvName, tvID,tvQuality;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAvt = itemView.findViewById(R.id.imgTop);
            tvID = itemView.findViewById(R.id.tvName_id_top);
            tvQuality = itemView.findViewById(R.id.tvQualityTop);
            tvName = itemView.findViewById(R.id.tvName_top);
        }
    }
}
