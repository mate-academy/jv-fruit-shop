package main.model;

public class Product {
    private Transaction transaction;
    private String productName;
    private int quantity;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
            "transaction=" + transaction +
            ", productName='" + productName + '\'' +
            ", quantity=" + quantity +
            '}';
    }
}
