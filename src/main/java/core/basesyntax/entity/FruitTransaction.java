package core.basesyntax.entity;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String operation) {
            this.code = operation;
        }

        public String getOperation() {
            return code;
        }

        public void setOperation(String operation) {
            this.code = operation;
        }
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

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}
