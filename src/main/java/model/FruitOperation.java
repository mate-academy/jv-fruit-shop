package model;

import java.util.Objects;

public class FruitOperation {
    private Fruit fruit;
    private OperationType operationType;
    private int amount;

    public FruitOperation(Fruit fruit, OperationType operationType, int amount) {
        this.fruit = fruit;
        this.operationType = operationType;
        this.amount = amount;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

        if (amount != that.amount) {
            return false;
        }
        if (!Objects.equals(fruit, that.fruit)) {
            return false;
        }
        return operationType == that.operationType;
    }

    @Override
    public int hashCode() {
        int result = fruit != null ? fruit.hashCode() : 0;
        result = result + (operationType != null ? operationType.hashCode() : 0);
        result = result + amount;
        return result;
    }
}
