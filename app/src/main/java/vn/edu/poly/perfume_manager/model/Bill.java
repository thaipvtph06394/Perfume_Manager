package vn.edu.poly.perfume_manager.model;

public class Bill {
    public String bill_id;
    public String bill_name;
    public String bill_product_id;
    public long bill_date;
    public int bill_quality;

    public Bill(String bill_id,String bill_name, String bill_product_id, long bill_date, int bill_quality) {
        this.bill_id = bill_id;
        this.bill_name = bill_name;
        this.bill_product_id = bill_product_id;
        this.bill_date = bill_date;
        this.bill_quality = bill_quality;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_product_id() {
        return bill_product_id;
    }

    public void setBill_product_id(String bill_product_id) {
        this.bill_product_id = bill_product_id;
    }

    public long getBill_date() {
        return bill_date;
    }

    public void setBill_date(long bill_date) {
        this.bill_date = bill_date;
    }

    public int getBill_quality() {
        return bill_quality;
    }

    public void setBill_quality(int bill_quality) {
        this.bill_quality = bill_quality;
    }
}
