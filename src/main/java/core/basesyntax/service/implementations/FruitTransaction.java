package core.basesyntax.service.implementations;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public void setOperation(String value) {
        for (Operation o : Operation.values()) {
            if (value.equals(o.getOperation())) {
                this.operation = o;
            }
        }
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
