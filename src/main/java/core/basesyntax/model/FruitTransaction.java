package core.basesyntax.model;

import java.util.NoSuchElementException;

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

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final String OPERATION_EXCEPTION = "Can't find operation";
        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation findByCode(String code) {
            switch (code) {
                case "b":
                    return BALANCE;
                case "s":
                    return SUPPLY;
                case "p":
                    return PURCHASE;
                case "r":
                    return RETURN;
                default:
                    throw new NoSuchElementException(OPERATION_EXCEPTION);
            }
        }
    }
}
