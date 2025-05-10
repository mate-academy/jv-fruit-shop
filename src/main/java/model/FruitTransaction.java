package model;

import java.util.Arrays;

public class FruitTransaction {
    private FruitTransaction.Operation operation;
    private String fruitName;
    private int fruitQuantity;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public FruitTransaction.Operation getOperationType() {
        return operation;
    }

    public void setOperation(FruitTransaction.Operation operation) {
        this.operation = operation;
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

        public static Operation getByCode(String lineField) {
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getOperation().equals(lineField))
                    .findFirst()
                    .get();
        }

        public String getOperation() {
            return operation;
        }
    }
}
