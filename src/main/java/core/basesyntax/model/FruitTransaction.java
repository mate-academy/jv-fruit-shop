package core.basesyntax.model;

import java.util.Arrays;

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
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");
        private String activity;

        Operation(String activity) {
            this.activity = activity;
        }

        public String getActivity() {
            return activity;
        }

        public static Operation getByActivity(String activity) {
            return Arrays.stream(Operation.values())
                    .filter(operation -> activity.equals(operation.getActivity()))
                    .findFirst().get();
        }
    }
}
