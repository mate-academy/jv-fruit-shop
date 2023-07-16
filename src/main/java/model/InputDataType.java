package model;

import java.util.Objects;

public class InputDataType {
    private final String operation;
    private final String fruit;
    private final Integer quantity;

    public InputDataType(String operation, String fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InputDataType other = (InputDataType) obj;
        return Objects.equals(operation, other.operation)
                && Objects.equals(fruit, other.fruit)
                && Objects.equals(quantity, other.quantity);
    }
}
