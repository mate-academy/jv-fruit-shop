package core.basesyntax.model;

import java.util.NoSuchElementException;
import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String fruit, int quantity, Operation operation) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operation = operation;
    }

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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != FruitTransaction.class) {
            return false;
        }
        FruitTransaction fruitTransaction = (FruitTransaction) obj;
        return Objects.equals(this.fruit, fruitTransaction.fruit)
                && Objects.equals(this.quantity, fruitTransaction.quantity)
                && Objects.equals(this.operation, fruitTransaction.operation);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation getByCode(String code) {
            for (Operation operation : values()) {
                if (operation.getOperation().equals(code)) {
                    return operation;
                }
            }
            throw new NoSuchElementException("Unknown operation: " + code);
        }
    }
}
