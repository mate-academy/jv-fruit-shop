package core.basesyntax.model;

import java.util.NoSuchElementException;

public class FruitTransaction {
    private final Operation operation;
    private final String fruitName;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
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

        public static Operation getOperationByCode(String code) {
            switch (code) {
                case "b" : return BALANCE;
                case "s" : return SUPPLY;
                case "p" : return PURCHASE;
                case "r" : return RETURN;
                default: throw new NoSuchElementException("Wrong operation type");
            }
        }
    }
}
