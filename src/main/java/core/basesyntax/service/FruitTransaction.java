package core.basesyntax.service;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final Integer quantity;

    public FruitTransaction(Operation operation, String fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private final String operation;
        Operation(String op) {
            operation = op;
        }

        public String getOperation() {
            return operation;
        }
    }
}
