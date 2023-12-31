package core.basesyntax.model;

import java.util.Objects;

public class FruitOperation {
    private Operation operation;
    private Fruit fruit;

    public FruitOperation(Operation operation, Fruit fruit) {
        this.operation = operation;
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private final String code;

        Operation(String code) {
            this.code = code;
        }

    }

    @Override
    public String toString() {
        return "FruitOperation{"
                + "operation=" + operation
                + ", fruit=" + fruit
                + '}';
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
        return operation == that.operation && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit);
    }
}
