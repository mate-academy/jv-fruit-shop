package model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String symbol, String fruit, int quantity) {
        this.operation = convertStringIntoOperation(symbol);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    private Operation convertStringIntoOperation(String symbol) {
        return switch (symbol) {
            case "b" -> Operation.BALANCE;
            case "s" -> Operation.SUPPLY;
            case "p" -> Operation.PURCHASE;
            case "r" -> Operation.RETURN;
            default -> throw new IllegalArgumentException(
                    "There is no Enum element, corresponding to the argument " + symbol);
        };
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String transaction;

        Operation(String lineFromFile) {
            transaction = lineFromFile;
        }

        public String getOperatingSymbol() {
            return transaction;
        }
    }
}
