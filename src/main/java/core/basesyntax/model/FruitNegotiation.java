package core.basesyntax.model;

import core.basesyntax.exception.FruitStoreException;

public class FruitNegotiation {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public FruitNegotiation(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruitName;
    }

    public void setFruit(String fruit) {
        this.fruitName = fruit;
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

        private final String codeOp;

        Operation(String codeOp) {
            this.codeOp = codeOp;
        }

        public String getCode() {
            return codeOp;
        }

        public static Operation getCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new FruitStoreException("Unknowing code of operation signature " + code);
        }
    }
}
