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
import vn.edu.poly.perfume_manager.listener.OnViewBill;
import vn.edu.poly.perfume_manager.model.Bill;
import vn.edu.poly.perfume_manager.ui.BillActivity;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    private List<Bill> billList;
    private OnDelete onDelete;
    private OnViewBill<Bill> onViewBill;
    private OnEdit onEdit;


    public BillAdapter(List<Bill> billList, OnDelete onDelete, OnEdit onEdit, BillActivity onViewBill ) {
        this.billList = billList;
        this.onDelete = onDelete;
        this.onEdit = onEdit;

    }

    @NonNull
    @Override
    public vn.edu.poly.perfume_manager.adapter.BillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_bill,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return billList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull vn.edu.poly.perfume_manager.adapter.BillAdapter.ViewHolder holder, final int position) {
        final Bill st = billList.get(position);
        holder.tvID.setText("Mã hóa đơn: "+st.bill_id);
        holder.tvQuality.setText("Số lượng: "+st.bill_quality);
        holder.tvNgayMua.setText("Ngày thanh toán: "+st.bill_date);
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDelete.OnDelete(st.bill_id,position);
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEdit.OnEdit(st);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewBill.onViewBill(st);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgAvt,imgDelete,imgEdit;
        public TextView tvID,tvNgayMua,tvQuality;
        public ViewHolder(View itemView) {
            super(itemView);
            imgAvt = itemView.findViewById(R.id.imgBill);
            imgDelete = itemView.findViewById(R.id.imgdeletebill);
            imgEdit = itemView.findViewById(R.id.imgeditbill);
            tvID = itemView.findViewById(R.id.tvBill_id);
            tvQuality = itemView.findViewById(R.id.tvSoluong_bill);
            tvNgayMua = itemView.findViewById(R.id.tvNgayMua);


        }
    }
}
