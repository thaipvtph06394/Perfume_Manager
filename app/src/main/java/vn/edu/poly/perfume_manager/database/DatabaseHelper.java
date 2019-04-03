package vn.edu.poly.perfume_manager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import vn.edu.poly.perfume_manager.Constant;

public class DatabaseHelper extends SQLiteOpenHelper implements Constant {
    public DatabaseHelper(Context context) {
        super(context, "PerfumeManager", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_BILL_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);

        if (Constant.isDEBUG) Log.e("CREATE_USER_TABLE", CREATE_USER_TABLE);
        if (Constant.isDEBUG) Log.e("CREATE_BILL_TABLE", CREATE_BILL_TABLE);
        if (Constant.isDEBUG) Log.e("CREATE_PRODUCT_TABLE", CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BILL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }
}
