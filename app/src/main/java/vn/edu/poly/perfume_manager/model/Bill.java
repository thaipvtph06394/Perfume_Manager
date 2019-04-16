package vn.edu.poly.perfume_manager.model;

public class Bill {
    public String bill_id;
    public String bill_product_id;
    public long bill_date;
    public int bill_quality;


    public Bill(String bill_id, String bill_product_id, long bill_date, int bill_quality) {
        this.bill_id = bill_id;
        this.bill_product_id = bill_product_id;
        this.bill_date = bill_date;
        this.bill_quality = bill_quality;
    }


    public Bill() {

    }
}
