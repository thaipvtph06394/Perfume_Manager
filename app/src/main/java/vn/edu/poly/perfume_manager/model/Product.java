package vn.edu.poly.perfume_manager.model;

public class Product {
    public String product_id;
    public String product_name;
    public String product_brand;
    public String product_made;
    public long product_price_in;
    public long product_price_out;
    public int product_quality;
    public String product_detail;

    public Product(String product_id, String product_name, String product_brand, String product_made,
                   long product_price_in,long product_price_out, int product_quality, String product_detail) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_brand = product_brand;
        this.product_made = product_made;
        this.product_price_in = product_price_in;
        this.product_price_out = product_price_out;
        this.product_quality = product_quality;
        this.product_detail = product_detail;
    }

    public Product() {

    }



}
