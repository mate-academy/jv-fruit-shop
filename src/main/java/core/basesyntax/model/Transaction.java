package core.basesyntax.model;

import java.util.Objects;

public class Transaction {
    private Fruit fruit;
    private Operation operation;
    private int amountFruits;

    public Transaction(String operation, Fruit fruit, int amountFruits) {
        this.fruit = fruit;
        this.operation = Operation.findOperation(operation);
        this.amountFruits = amountFruits;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getAmountFruits() {
        return amountFruits;
    }

    public void setAmountFruits(int amountFruits) {
        this.amountFruits = amountFruits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction that = (Transaction) o;
        return getAmountFruits() == that.getAmountFruits() && Objects.equals(getFruit(),
                that.getFruit()) && getOperation() == that.getOperation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruit(), getOperation(), getAmountFruits());
    }

    @Override
    public String toString() {
        return "Transaction: "
                + "fruit = " + fruit
                + ", operation = " + operation
                + ", amountFruits = " + amountFruits
                + ".";
    }
}
