package core.basesyntax.model;

import java.math.BigDecimal;

public class FruitReport {
    private String fruit;
    private BigDecimal quantity;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
