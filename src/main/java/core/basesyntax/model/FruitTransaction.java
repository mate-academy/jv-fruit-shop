package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private OperationName name;
    private String nameOfObject;
    private int amount;

    public FruitTransaction(OperationName name, String nameOfObject, int amount) {
        this.name = name;
        this.nameOfObject = nameOfObject;
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getNameOfObject() {
        return this.nameOfObject;
    }

    public OperationName getName() {
        return this.name;
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
        return amount == that.amount
                && name == that.name
                && Objects.equals(nameOfObject, that.nameOfObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nameOfObject, amount);
    }
}
