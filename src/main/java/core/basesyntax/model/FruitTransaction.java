package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private String code;

        Operation(String operation) {
            this.code = operation;
        }

        public String getOperation() {
            return code;
        }

        public static Operation getByCode(String code) {
            for (Operation o : Operation.values()) {
                if (o.code.equalsIgnoreCase(code)) {
                    return o;
                }
            }
            throw new IllegalArgumentException("Wrong operation code.");
        }
    }
}
