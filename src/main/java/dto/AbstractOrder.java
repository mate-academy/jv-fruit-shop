package dto;

import java.time.LocalDate;

public abstract class AbstractOrder {
    private String type;
    private String productName;
    private LocalDate date;
    private int quantity;

    public AbstractOrder(String type) {
        this.type = type;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }
}
