package core.basesyntax.model;

import core.basesyntax.service.exceptions.InvalidDataException;
import core.basesyntax.service.exceptions.InvalidQuantityException;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(Operation operation, Fruit fruit, int quantity) {
        if (operation == null) {
            throw new InvalidDataException("Given operation can't be null");
        }
        if (fruit == null) {
            throw new InvalidDataException("Given fruit can't be null");
        }
        if (quantity < 0) {
            throw new InvalidQuantityException("Given quantity can't be negative value");
        }
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction() {
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        if (operation == null) {
            throw new InvalidDataException("Given operation can't be null");
        }
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        if (fruit == null) {
            throw new InvalidDataException("Given fruit can't be null");
        }
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new InvalidQuantityException("Given quantity can't be negative value");
        }
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + code);
        }
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
