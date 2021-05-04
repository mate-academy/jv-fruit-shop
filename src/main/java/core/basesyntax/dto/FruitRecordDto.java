package core.basesyntax.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import java.util.Objects;

public class FruitRecordDto {
    private Fruit fruit;
    private int quantity;
    private OperationType operationType;

    public FruitRecordDto(Fruit fruit, int quantity, OperationType operationType) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operationType = operationType;
    }

    public FruitRecordDto() {

    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitRecordDto current = (FruitRecordDto) o;
        return Objects.equals(fruit.getName(), current.fruit.getName())
                && getQuantity() == current.getQuantity()
                && getOperationType() == current.getOperationType();
    }

    @Override
    public int hashCode() {
        int result = 11;
        result *= 17 + (fruit == null ? 0 : fruit.hashCode());
        result *= 17 + quantity;
        result *= 17 + (operationType == null ? 0 : operationType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FruitRecordDto{" + "fruitName='" + fruit.getName()
                + '\'' + ", quantity=" + quantity + ", operationType="
                + operationType + '}';
    }
}
