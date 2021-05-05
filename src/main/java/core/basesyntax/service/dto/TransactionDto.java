package core.basesyntax.service.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import java.util.Objects;

public class TransactionDto {
    private final OperationType operationType;
    private final Fruit fruit;
    private final int quantity;

    public TransactionDto(OperationType operationType, Fruit fruit, Integer quantity) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
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
        TransactionDto that = (TransactionDto) o;
        return quantity == that.quantity
                && operationType == that.operationType
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, fruit, quantity);
    }
}
