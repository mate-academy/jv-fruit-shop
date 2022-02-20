package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {

    private final Operation operation;
    private final String fruitName;
    private final int quantity;


    public FruitTransaction(String operation, String fruit, int quantity) {
        this.operation = Operation.getOperation(operation);
        this.fruitName = fruit;
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

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static FruitTransaction.Operation getOperation(String operation) {
            return Arrays.stream(values())
                    .filter(o -> o.getOperation().equals(operation))
                    .findFirst().orElseThrow(() ->
                            new RuntimeException("There is no such operation: " + operation));
        }

    }

}