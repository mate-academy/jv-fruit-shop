package core.basesyntax.model;

import java.util.Arrays;

public class FruitShopTransactions {
    private String fruit;
    private Operation operation;
    private int quantity;

    public FruitShopTransactions(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
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
    }

    public static Operation getOperationByLetter(String inputOperation) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperation().equals(inputOperation)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation " + inputOperation + " not found");
    }
}
