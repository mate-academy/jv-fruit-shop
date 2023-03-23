package core.basesyntax.model;

public class FruitTransaction {
    private String operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        switch (operation) {
            case "b":
                this.operation = Operation.BALANCE.getCode();
                break;
            case "s":
                this.operation = Operation.SUPPLY.getCode();
                break;
            case "p":
                this.operation = Operation.PURCHASE.getCode();
                break;
            case "r":
                this.operation = Operation.RETURN.getCode();
                break;
            default: {
                this.operation = null;
            }
        }
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
    }
}
