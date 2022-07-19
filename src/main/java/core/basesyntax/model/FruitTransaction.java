package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private String fruitName;
    private Operation operation;
    private int quantity;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

        private final String letter;

        Operation(String operation) {
            this.letter = operation;
        }

        public String getOperation() {
            return letter;
        }

        public static Operation identifyOperation(String letter) {
            try {
                return Arrays.stream(FruitTransaction.Operation.values())
                        .filter(e -> e.getOperation().equals(letter))
                        .findFirst()
                        .get();
            } catch (Exception e) {
                throw new RuntimeException("Letter is invalid", e);
            }
        }
    }
}
