package vn.edu.poly.perfume_manager.model;

public class Product {
    public String product_id;
    public String product_name;
    public String product_brand;
    public String product_made;
    public long product_price_in;
    public long product_price_out;
    public int product_quality;
    public long product_date;
    public String product_detail;

    public Product(String product_id, String product_name, String product_brand, String product_made,
                   long product_price_in,long product_price_out, int product_quality, long product_date, String product_detail) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_brand = product_brand;
        this.product_made = product_made;
        this.product_price_in = product_price_in;
        this.product_price_out = product_price_out;
        this.product_quality = product_quality;
        this.product_date = product_date;
        this.product_detail = product_detail;
    }


    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public String getProduct_made() {
        return product_made;
    }

    public void setProduct_made(String product_made) {
        this.product_made = product_made;
    }

    public long getProduct_price_in() {
        return product_price_in;
    }

    public void setProduct_price_in(int product_price_in) {
        this.product_price_in = product_price_in;
    }

    public long getProduct_price_out() {
        return product_price_out;
    }

    public void setProduct_price_out(int product_price_out) {
        this.product_price_out = product_price_out;
    }

    public int getProduct_quality() {
        return product_quality;
    }

    public void setProduct_quality(int product_quality) {
        this.product_quality = product_quality;
    }

    public long getProduct_date() {
        return product_date;
    }

    public void setProduct_date(long product_date) {
        this.product_date = product_date;
    }

    public String getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(String product_detail) {
        this.product_detail = product_detail;
    }
}
