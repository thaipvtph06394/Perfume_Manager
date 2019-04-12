package vn.edu.poly.perfume_manager.model;

public class SelectTopProduct {
    String id;
    int amount;

    public SelectTopProduct(String id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public SelectTopProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
