package core.basesyntax.model;

import java.util.StringJoiner;

public class Product {
    private final String name;
    private int quantity;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("quantity=" + quantity)
                .toString();
    }
}
