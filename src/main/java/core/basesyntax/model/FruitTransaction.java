package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(String code) {
        switch (code) {
            case "b":
                this.operation = Operation.BALANCE;
                break;
            case "s":
                this.operation = Operation.SUPPLY;
                break;
            case "p":
                this.operation = Operation.PURCHASE;
                break;
            case "r":
                operation = Operation.RETURN;
                break;
            default:
        }
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

        private String code;

        Operation(String code) {
            this.code = code;
        }
    }
}

