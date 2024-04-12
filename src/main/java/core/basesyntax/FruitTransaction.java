package core.basesyntax;

public class FruitTransaction {
    private Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        switch (operation) {
            case "b" -> this.operation = Operation.BALANCE;
            case "p" -> this.operation = Operation.PURCHASE;
            case "r" -> this.operation = Operation.RETURN;
            case "s" -> this.operation = Operation.SUPPLY;
            default -> this.operation = null;
        }
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

    public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

        Operation(String code) {

        }
    }
}
