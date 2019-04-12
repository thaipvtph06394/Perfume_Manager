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
import vn.edu.poly.perfume_manager.listener.OnDelete;
import vn.edu.poly.perfume_manager.listener.OnEdit;
import vn.edu.poly.perfume_manager.listener.OnViewProduct;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.ui.AddProductActivity;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;
    private OnDelete onDelete;
    private OnEdit onEdit;
    private OnViewProduct onViewProduct;

    public ProductAdapter(List<Product> productList,OnDelete onDelete,OnEdit onEdit,OnViewProduct onViewProduct) {
        this.productList = productList;
        this.onDelete = onDelete;
        this.onEdit = onEdit;
        this.onViewProduct= onViewProduct;

    }



    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, final int position) {
        final Product product = productList.get(position);
        holder.tvName.setText("Nước hoa "+product.product_name);
        holder.tvQuality.setText("Số lượng: "+product.product_quality);
        holder.tvPrice.setText("Giá :"+product.product_price_out);
        holder.tvBrand.setText("Thương hiệu: "+product.product_brand);
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDelete.OnDelete(product.product_id,position);
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEdit.OnEdit(product);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewProduct.OnViewProduct(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgAvt,imgEdit,imgDelete;
        public TextView tvName , tvBrand,tvPrice,tvQuality;
        public ViewHolder(View itemView) {
            super(itemView);
            imgAvt = itemView.findViewById(R.id.imgProduct);
            imgEdit = itemView.findViewById(R.id.imgeditproduct);
            imgDelete = itemView.findViewById(R.id.imgdeleteproduct);
            tvName = itemView.findViewById(R.id.tvNameProduct);
            tvBrand = itemView.findViewById(R.id.tvBrand);
            tvPrice= itemView.findViewById(R.id.tvGia);
            tvQuality = itemView.findViewById(R.id.tvQuality_product);



        }
    }
}
