package vn.edu.poly.perfume_manager.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.perfume_manager.Constant;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.model.Bill;

public class BillDAO implements Constant {
    private DatabaseHelper databaseHelper;

    public BillDAO(DatabaseHelper databaseHelper){this.databaseHelper = databaseHelper;}

    public long insertBill(Bill bill){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BILL_ID,bill.bill_id);
        contentValues.put(BILL_NAME,bill.bill_name);
        contentValues.put(BILL_PRODUCT_ID,bill.bill_product_id);
        contentValues.put(BILL_QUALITY,bill.bill_quality);
        contentValues.put(BILL_DATE,bill.bill_date);

        long result = sqLiteDatabase.insert(TABLE_BILL,null,contentValues);

        sqLiteDatabase.close();
        return result;
    }
    public long updateBill(Bill bill){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BILL_NAME,bill.bill_name);
        contentValues.put(BILL_PRODUCT_ID,bill.bill_product_id);
        contentValues.put(BILL_QUALITY,bill.bill_quality);
        contentValues.put(BILL_DATE,bill.bill_date);

        long result = sqLiteDatabase.update(TABLE_BILL,contentValues,BILL_ID+"=?",new String[]{bill.bill_id});

        sqLiteDatabase.close();
        return result;
    }
    public long deleteBill(String id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_BILL,BILL_ID+"=?",new String[]{id});

        sqLiteDatabase.close();
        return result;
    }
    public List<Bill> getAllBills(){
        List<Bill> bills = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_BILL, null);
        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                String bill_id = cursor.getString(cursor.getColumnIndex(BILL_ID));
                String bill_name = cursor.getString(cursor.getColumnIndex(BILL_NAME));
                String bill_product_id = cursor.getString(cursor.getColumnIndex(BILL_PRODUCT_ID));
                int bill_quality = cursor.getInt(cursor.getColumnIndex(BILL_QUALITY));
                long bill_date = cursor.getLong(cursor.getColumnIndex(BILL_DATE));

                Bill bill = new Bill(bill_id,bill_name,bill_product_id,bill_date,bill_quality);

                bills.add(bill);

            }while (cursor.moveToNext());
        }
        return bills;
    }
    public Bill getBillByID(String id){
        Bill bill = null;
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_BILL,new String[]{BILL_ID,BILL_PRODUCT_ID,BILL_DATE,BILL_QUALITY},
                BILL_ID +"=?",new String[]{id},null,null,null);
        if (cursor != null && cursor.getCount() > 0 ){
            cursor.moveToFirst();
            String bill_id = cursor.getString(cursor.getColumnIndex(BILL_ID));
            String bill_name = cursor.getString(cursor.getColumnIndex(BILL_NAME));
            String bill_product_id = cursor.getString(cursor.getColumnIndex(BILL_PRODUCT_ID));
            int bill_quality = cursor.getInt(cursor.getColumnIndex(BILL_QUALITY));
            long bill_date = cursor.getLong(cursor.getColumnIndex(BILL_DATE));

            bill = new Bill(bill_id,bill_name,bill_product_id,bill_date,bill_quality);
        }
        return bill;
    }
}
