package core.basesyntax.model;

import java.util.Objects;

public class FruitOperation {
    private String type;
    private String fruit;
    private int quantity;

    public FruitOperation(String type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitOperation that = (FruitOperation) o;
        return quantity == that.quantity
                && Objects.equals(type, that.type) && Objects.equals(fruit, that.fruit);
    }
}
