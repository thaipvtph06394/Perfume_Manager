package vn.edu.poly.perfume_manager.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.perfume_manager.Constant;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;
import vn.edu.poly.perfume_manager.model.Product;
import vn.edu.poly.perfume_manager.model.SelectTopProduct;

public class ProductDAO implements Constant{
    private DatabaseHelper databaseHelper;
    private static final String TAG = "NuocHoa";
    public ProductDAO(DatabaseHelper databaseHelper){this.databaseHelper = databaseHelper;}

    public long insertProduct(Product Product){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT_ID,Product.product_id);
        contentValues.put(PRODUCT_NAME,Product.product_name);
        contentValues.put(PRODUCT_BRAND,Product.product_brand);
        contentValues.put(PRODUCT_MADE,Product.product_made);
        contentValues.put(PRODUCT_PRICE_IN,Product.product_price_in);
        contentValues.put(PRODUCT_PRICE_OUT,Product.product_price_out);
        contentValues.put(PRODUCT_QUALITY,Product.product_quality);
        contentValues.put(PRODUCT_DETAIL,Product.product_detail);
        long resuft= sqLiteDatabase.insert(TABLE_PRODUCT,null,contentValues);
        databaseHelper.close();
        return resuft;
    }
    public long updateProduct(Product Product){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT_NAME,Product.product_name);
        contentValues.put(PRODUCT_BRAND,Product.product_brand);
        contentValues.put(PRODUCT_MADE,Product.product_made);
        contentValues.put(PRODUCT_PRICE_IN,Product.product_price_in);
        contentValues.put(PRODUCT_PRICE_OUT,Product.product_price_out);
        contentValues.put(PRODUCT_QUALITY,Product.product_quality);
        contentValues.put(PRODUCT_DETAIL,Product.product_detail);

        long result = sqLiteDatabase.update(TABLE_PRODUCT,contentValues,PRODUCT_ID+"=?",new String[]{Product.product_id});

        sqLiteDatabase.close();
        return result;
    }
    public long deleteProduct( String id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_PRODUCT,PRODUCT_ID+"=?",new String[]{String.valueOf(id)});


        return result;
    }
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_PRODUCT, null);
        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                String product_id = cursor.getString(cursor.getColumnIndex(PRODUCT_ID));
                String product_name = cursor.getString(cursor.getColumnIndex(PRODUCT_NAME));
                String product_brand = cursor.getString(cursor.getColumnIndex(PRODUCT_BRAND));
                String product_made = cursor.getString(cursor.getColumnIndex(PRODUCT_MADE));
                long product_price_in = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE_IN));
                long product_price_out = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE_OUT));
                int product_quality = cursor.getInt(cursor.getColumnIndex(PRODUCT_QUALITY));
                String product_detail = cursor.getString(cursor.getColumnIndex(PRODUCT_DETAIL));

                Product Product = new Product(product_id,product_name,product_brand,product_made,
                        product_price_in,product_price_out,product_quality,product_detail);

                products.add(Product);

            }while (cursor.moveToNext());
        }
        return products;
    }
    public Product getProductByID(String id){
        Product Product = null;
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_BILL,new String[]{BILL_ID,BILL_PRODUCT_ID,BILL_DATE,BILL_QUALITY},
                BILL_ID +"=?",new String[]{id},null,null,null);
        if (cursor != null && cursor.getCount() > 0 ){
            cursor.moveToFirst();
            String product_id = cursor.getString(cursor.getColumnIndex(PRODUCT_ID));
            String product_name = cursor.getString(cursor.getColumnIndex(PRODUCT_NAME));
            String product_brand = cursor.getString(cursor.getColumnIndex(PRODUCT_BRAND));
            String product_made = cursor.getString(cursor.getColumnIndex(PRODUCT_MADE));
            long product_price_in = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE_IN));
            long product_price_out = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE_OUT));
            int product_quality = cursor.getInt(cursor.getColumnIndex(PRODUCT_QUALITY));
            String product_detail = cursor.getString(cursor.getColumnIndex(PRODUCT_DETAIL));

            Product = new Product(product_id,product_name,product_brand,product_made,
                    product_price_in,product_price_out,product_quality,product_detail);
        }
        return Product;
    }
    public List<SelectTopProduct> getTop() {
        List<SelectTopProduct> selectTop10Books = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select Products.MaProduct as e, SUM(Bills.soLuong) as i from  Bills, Products where Products.MaProduct = Bills.MaProduct  group by Products.MaProduct order by SUM(Bills.soLuong) desc LIMIT 10",
                null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String id = cursor.getString(cursor.getColumnIndex("e"));
                int amount = cursor.getInt(cursor.getColumnIndex("i"));
                SelectTopProduct product = new SelectTopProduct();
                product.setId(id);
                product.setAmount(amount);

                selectTop10Books.add(product);

            } while (cursor.moveToNext());
        }

        return selectTop10Books;
    }

}
