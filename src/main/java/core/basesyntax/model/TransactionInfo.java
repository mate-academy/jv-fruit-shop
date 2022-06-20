package core.basesyntax.model;

import java.util.Objects;

public class TransactionInfo {
    private OperationWithFruit operationType;
    private Fruit fruit;
    private int quantityFruits;

    public TransactionInfo(String operationType, Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantityFruits = quantity;
        this.operationType = OperationWithFruit.findOperation(operationType);
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantityFruits() {
        return quantityFruits;
    }

    public void setQuantityFruits(int quantityFruits) {
        this.quantityFruits = quantityFruits;
    }

    public OperationWithFruit getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationWithFruit operationType) {
        this.operationType = operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionInfo that = (TransactionInfo) o;
        return quantityFruits == that.quantityFruits
                && Objects.equals(fruit, that.fruit)
                && operationType == that.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, quantityFruits, operationType);
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "fruit=" + fruit
                + ", quantity=" + quantityFruits
                + ", operationType=" + operationType
                + '}';
    }
}
