package core.basesyntax.model;

import java.util.Objects;

public class FruitTransfer {
    private Operation operation;
    private Fruit fruit;
    private int remainder;

    public FruitTransfer(Operation operation, Fruit fruit, int remainder) {
        this.operation = operation;
        this.fruit = fruit;
        this.remainder = remainder;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitTransfer)) {
            return false;
        }
        FruitTransfer that = (FruitTransfer) o;
        return remainder == that.remainder && operation == that.operation
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, remainder);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;
        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

    }
}
