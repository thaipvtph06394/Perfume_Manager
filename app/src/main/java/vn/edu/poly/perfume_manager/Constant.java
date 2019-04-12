package vn.edu.poly.perfume_manager;

public interface Constant {
    boolean isDEBUG = true;

    String D_DAY = "\"%Y-%m-%d\"";
    String M_MONTH = "\"%Y-%m\"";
    String Y_YEAR = "\"%Y\"";

    // user table

    String USER_TABLE = "Users";
    String COLUMN_USERNAME = "Username";
    String COLUMN_PASSWORD = "Password";
    String COLUMN_NAME = "Name";
    String COLUMN_PHONE_NUMBER = "Phone_number";

    String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "(" +
            COLUMN_USERNAME + " VARCHAR PRIMARY KEY," +
            COLUMN_PASSWORD + " VARCHAR," +
            COLUMN_NAME + " VARCHAR," +
            COLUMN_PHONE_NUMBER + " VARCHAR" +
            ")";


    // bill table
    String TABLE_BILL = "Bills";
    String BILL_ID = "MaBill";
    String BILL_PRODUCT_ID = "MaProduct";
    String BILL_DATE = "NgayMua";
    String BILL_QUALITY = "soLuong";


    String CREATE_BILL_TABLE = "CREATE TABLE " + TABLE_BILL + "(" +
            "" + BILL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + BILL_PRODUCT_ID + " NCHAR(10) , " +
            "" + BILL_DATE + " LONG NOT NULL , " +
            "" + BILL_QUALITY + " INT NOT NULL " +
            ")";





    // product table

    String TABLE_PRODUCT = "Products";
    String PRODUCT_ID = "MaProduct";
    String PRODUCT_NAME = "NameProduct";
    String PRODUCT_BRAND = "ThuongHieu";
    String PRODUCT_MADE = "XuatXu";
    String PRODUCT_PRICE_IN = "giaNhap";
    String PRODUCT_PRICE_OUT = "giaBan";
    String PRODUCT_QUALITY = "soLuong";
    String PRODUCT_DETAIL = "moTa";



    String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "(" +
            "" + PRODUCT_ID + " CHAR(10) PRIMARY KEY ," +
            "" + PRODUCT_NAME + " NVARCHAR(50)," +
            "" + PRODUCT_BRAND + " NVARCHAR(50)," +
            "" + PRODUCT_MADE + " NVARCHAR(50)," +
            "" + PRODUCT_PRICE_IN + " FLOAT NOT NULL ," +
            "" + PRODUCT_PRICE_OUT + " FLOAT NOT NULL ," +
            "" + PRODUCT_QUALITY + "  INT NOT NULL , " +
            "" + PRODUCT_DETAIL + " NVARCHAR(255) " +
            ")";


}
