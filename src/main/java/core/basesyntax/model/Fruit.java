package core.basesyntax.model;

import java.math.BigDecimal;

public class Fruit {
    private final String name;
    private BigDecimal quantity;

    public Fruit(String name, BigDecimal quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
