package core.basesyntax.models;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
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
        FruitTransaction fruitTransaction = (FruitTransaction) o;
        return Objects.equals(fruit, fruitTransaction.fruit)
                && Objects.equals(operation, fruitTransaction.operation)
                && Objects.equals(quantity, fruitTransaction.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, operation, quantity);
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

        public static Operation getByCode(String code) {
            for (Operation operation : Operation.values()) {
                if (code.equals(operation.operation)) {
                    return operation;
                }
            }
            throw new RuntimeException("There is no such code for enum Operation");
        }
    }
}