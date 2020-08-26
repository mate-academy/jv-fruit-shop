package core.basesyntax.items;

import java.time.LocalDate;

public class Product {
    private String type;
    private Integer quantity;
    private LocalDate date;

    public Product(String type, Integer quantity, LocalDate expirationDate) {
        this.type = type;
        this.quantity = quantity;
        this.date = expirationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
