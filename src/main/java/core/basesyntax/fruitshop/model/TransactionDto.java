package core.basesyntax.fruitshop.model;

import java.util.Objects;

public class TransactionDto {
    private final OperationType operationType;
    private final Fruit fruit;
    private final Integer amount;

    public TransactionDto(OperationType operationType, Fruit fruit, Integer amount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getAmount() {
        return amount;
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
        return operationType == that.operationType
                && fruit.equals(that.fruit) && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, fruit, amount);
    }
}
