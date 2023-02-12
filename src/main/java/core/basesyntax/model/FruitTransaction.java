package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
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

        private String firstLetter;

        Operation(String action) {
            this.firstLetter = action;
        }

        public String getFirstLetter() {
            return firstLetter;
        }

        public FruitTransaction.Operation getOperationByFirstLetter(String string) {
            Operation[] operations = Operation.values();
            return Arrays.stream(operations)
                    .filter(v -> v.getFirstLetter().equals(string))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(
                            "Incorrect action type: \"" + string + "\" in the source file"));
        }
    }
}
