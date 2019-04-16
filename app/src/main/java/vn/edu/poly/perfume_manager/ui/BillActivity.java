package vn.edu.poly.perfume_manager.ui;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vn.edu.poly.perfume_manager.Constant;
import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.adapter.AdapterProductSpinner;
import vn.edu.poly.perfume_manager.adapter.BillAdapter;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.listener.OnDelete;
import vn.edu.poly.perfume_manager.listener.OnEdit;
import vn.edu.poly.perfume_manager.listener.OnViewBill;
import vn.edu.poly.perfume_manager.model.Bill;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.sqlitedao.BillDAO;
import vn.edu.poly.perfume_manager.sqlitedao.ProductDAO;
import vn.edu.poly.perfume_manager.sqlitedao.TopDAO;

public class BillActivity extends AppCompatActivity implements OnDelete, OnEdit, OnViewBill<Bill>, Constant {
    private Toolbar toolbarBill;
    private RecyclerView RecyclerViewBill;
    private TextView tvDoanhThuNgay;
    private FloatingActionButton fbtnBill;
    private DatabaseHelper databaseHelper;
    private List<Bill> billList;
    private BillDAO billDAO;
    private TopDAO topDAO;
    private String billID;
    private BillAdapter adapterBill;
    long datePicker = -1;
    TextView tvDateBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        databaseHelper = new DatabaseHelper(this);
        billDAO = new BillDAO(databaseHelper);
        topDAO = new TopDAO(databaseHelper);
        billList = new ArrayList<>();
        initView();
        toolbarView();
        setData();
        // nhận giá trị từ màn hình bill
        billID = getIntent().getStringExtra(BILL_ID);
        setMany(billID);

        fbtnBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }


        });

        toolbarBill.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void setData() {

        billList = billDAO.getAllBills();
        adapterBill = new BillAdapter(billList,this,this,this);
        RecyclerViewBill.setAdapter(adapterBill);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        RecyclerViewBill.setLayoutManager(manager);
    }

    private void toolbarView() {
        toolbarBill = findViewById(R.id.toolbarBill);
        setSupportActionBar(toolbarBill);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarBill.setTitleTextColor(Color.WHITE);
        toolbarBill.setTitle("Hóa Đơn");
        toolbarBill.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
    }

    private void initView() {
        RecyclerViewBill = (RecyclerView) findViewById(R.id.RecyclerView_Bill);
        tvDoanhThuNgay = (TextView) findViewById(R.id.tvDoanhThuNgay);
        fbtnBill = (FloatingActionButton) findViewById(R.id.fbtn_Bill);

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

    public void abc(){
        Spinner spIDBill;
        EditText edQualityBill;




    }
    private void showDialogAdd() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_add_bill, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        final Spinner spIDBill = dialogView.findViewById(R.id.spID_Bill);
        final EditText edQualityBill = dialogView.findViewById(R.id.edQuality_Bill);
        tvDateBill = dialogView.findViewById(R.id.tvDateBill);
        final Button btnDateBill = dialogView.findViewById(R.id.btnDate_Bill);
        final Button btnAdd = dialogView.findViewById(R.id.btnAdd);
        final Button btnCancel = dialogView.findViewById(R.id.btnCancel);

        List<Product> products = new ProductDAO(databaseHelper).getAllProducts();
        spIDBill.setAdapter(new AdapterProductSpinner(this, products));
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = BillActivity.this.billID;
                String sp = ((Product) spIDBill.getSelectedItem()).product_name;
                Integer quality = Integer.parseInt(edQualityBill.getText().toString().trim());
                if (datePicker < 0) return;
                Bill bill = new Bill(id,sp,datePicker,quality);
                long result = billDAO.insertBill(bill);
                if (result > 0) {

                    billList.add(bill);
                    adapterBill.notifyDataSetChanged();


                    setData();
                    dialog1.dismiss();
                    Toast.makeText(getApplicationContext(), "Thêm hóa đơn thành công!", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Thêm hóa đơn thất bại!", Toast.LENGTH_LONG).show();

                }
            }
        });
        btnDateBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDate();
            }


        });


    }
    private void showDialogDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        // thiet lap thong tin cho date picker

        final DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Integer yy = year;
                Integer mm = month;
                Integer dd = dayOfMonth;


                Calendar calendar = Calendar.getInstance();

                calendar.set(yy , mm, dd);

                //
                long startTime = calendar.getTimeInMillis();

                BillActivity.this.datePicker = calendar.getTimeInMillis();

                tvDateBill.setText(new Date(startTime).toString());


            }
        }, year, month, day);

        datePicker.show();
    }



    @Override
    public void onViewBill(Bill bill) {

    }
    public  void  setMany(String BillId){
        String tong= String.valueOf(billDAO.totalBill(BillId));
        tvDoanhThuNgay.setText(tong+" Đ");
    }

    @Override
    public void OnEdit(final String id, final int posion) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_edit_bill, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        billDAO = new BillDAO(databaseHelper);


        final Spinner spIDBill;
        final EditText edQualityBill;
        TextView tvDateBill;
        Button btnDateBill;
        Button btnEdit;
        Button btnEditCancel;
        spIDBill = (Spinner) dialogView.findViewById(R.id.spID_Bill);
        edQualityBill = (EditText) dialogView.findViewById(R.id.edQuality_Bill);
        tvDateBill = (TextView) dialogView.findViewById(R.id.tvDateBill);
        btnDateBill = (Button) dialogView.findViewById(R.id.btnDate_Bill);
        btnEdit = (Button) dialogView.findViewById(R.id.btnEdit);
        btnEditCancel = (Button) dialogView.findViewById(R.id.btnEditCancel);


        List<Product> products = new ProductDAO(databaseHelper).getAllProducts();
        spIDBill.setAdapter(new AdapterProductSpinner(this, products));
        final Bill bill = billList.get(posion);
        edQualityBill.setText(bill.bill_quality);
        tvDateBill.setText((int) bill.bill_date);
        spIDBill.getSelectedItem().toString();

        btnEditCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sp = ((Product) spIDBill.getSelectedItem()).product_name;
                Integer quality = Integer.parseInt(edQualityBill.getText().toString().trim());
                if (datePicker < 0) return;
                Bill bill1 = new Bill(null,sp,datePicker,quality);

                if (billDAO.updateBill(bill1)>0){
                    Toast.makeText(BillActivity.this, "Chỉnh sửa thành công", Toast.LENGTH_SHORT).show();
                    billList.set(posion, new Bill(bill.bill_id,bill.bill_product_id,bill.bill_date,bill.bill_quality));
                    adapterBill.notifyDataSetChanged();
                }else {
                    Toast.makeText(BillActivity.this, "Chỉnh sửa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void OnDelete(final String id, final int position) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Bạn có muốn xóa hóa đơn này không?");
        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                billDAO.deleteBill(id);
                billList.remove(position);
                adapterBill.notifyDataSetChanged();
                setData();
            }
        });
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
