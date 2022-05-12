package core.basesyntax.model;

public class FruitTransaction {
    private FruitTransaction.Operation operation;
    private String fruit;
    private int quantity;

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOperation(FruitTransaction.Operation operation) {
        this.operation = operation;
    }

    public FruitTransaction.Operation getOperation() {
        return operation;
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

        public static FruitTransaction.Operation getOperation(String operation) {
            return operation.equals("b") ? BALANCE
                    : operation.equals("s") ? SUPPLY
                    : operation.equals("p") ? PURCHASE
                    : RETURN;
        }
    }
}

