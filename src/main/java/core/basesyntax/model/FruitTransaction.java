package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruitType;
    private int fruitQuantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String letter;

        Operation(String operation) {
            this.letter = operation;
        }

        public String getOperation() {
            return letter;
        }

        public static Operation getOperationType(String letter) {
            return Arrays.stream(FruitTransaction.Operation.values())
                    .filter(e -> e.getOperation().equals(letter))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
