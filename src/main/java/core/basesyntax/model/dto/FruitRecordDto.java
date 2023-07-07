package core.basesyntax.model.dto;

import core.basesyntax.service.Operation;
import java.util.Objects;

public class FruitRecordDto {
    private Operation operationType;
    private String fruit;
    private Integer quantity;

    public FruitRecordDto(Operation operationType, String fruit, Integer quantity) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitRecordDto that = (FruitRecordDto) o;
        return operationType == that.operationType
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, fruit, quantity);
    }

    @Override
    public String toString() {
        return "FruitRecordDto{"
                + "operationType=" + operationType
                + ", fruitName='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
