package core.basesyntax.model;

import core.basesyntax.exception.ActionNegativeQuantityException;

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
        if (quantity < 0) {
            throw new ActionNegativeQuantityException(
                    String.format("You try to save negative quantity of product (%d)", quantity));
        }
        this.quantity = quantity;
    }
}
