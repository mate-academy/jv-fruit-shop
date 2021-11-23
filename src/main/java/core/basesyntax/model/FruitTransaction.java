package core.basesyntax.model;

import core.basesyntax.service.operationhandler.Operation;
import java.util.Objects;

public class FruitTransaction {
    private final Operation operation;
    private final Fruit name;
    private int amount;

    public FruitTransaction(Operation operation, Fruit name, int amount) {
        this.operation = operation;
        this.name = name;
        this.amount = amount;
    }

    public Fruit getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public Operation getOperation() {
        return operation;
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
        FruitTransaction that = (FruitTransaction) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }
}
