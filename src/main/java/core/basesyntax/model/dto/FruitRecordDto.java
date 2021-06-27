package core.basesyntax.model.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Operation;
import java.util.Objects;

public class FruitRecordDto {
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

    public FruitRecordDto(Operation operation, Fruit fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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
        FruitRecordDto that = (FruitRecordDto) o;
        return operation == that.operation
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
    }
}
