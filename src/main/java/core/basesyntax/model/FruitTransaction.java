package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
        FruitTransaction that = (FruitTransaction) o;
        return getQuantity() == that.getQuantity() && getOperation() == that.getOperation()
                && Objects.equals(getFruit(), that.getFruit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperation(), getFruit(), getQuantity());
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String typeOfOperation;

        Operation(String type) {
            this.typeOfOperation = type;
        }

        public String getTypeOfOperation() {
            return typeOfOperation;
        }
    }
}
