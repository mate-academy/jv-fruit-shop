package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Operation operation;

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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                this.operation = operation;
                return;
            }
        }

        throw new RuntimeException("operation don't exist for this code");
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

        public String getCode() {
            return code;
        }
    }
}
