package core.basesyntax.items;

import java.time.LocalDate;

public class Product {
    private final String type;
    private Integer quantity;
    private final LocalDate date;

    public Product(String type, Integer quantity, LocalDate expirationDate) {
        this.type = type;
        this.quantity = quantity;
        this.date = expirationDate;
    }

    public String getType() {
        return type;
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
}
