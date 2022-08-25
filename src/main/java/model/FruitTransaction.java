package model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String type, String fruit, int quantity) {
        switch (type) {
            case "b":
                operation = Operation.BALANCE;
                break;
            case "s":
                operation = Operation.SUPPLY;
                break;
            case "p":
                operation = Operation.PURCHASE;
                break;
            case "r":
                operation = Operation.RETURN;
                break;
            default:
        }
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(operation).append(":").append(fruit).append(":")
                .append(quantity).toString();
    }
}
