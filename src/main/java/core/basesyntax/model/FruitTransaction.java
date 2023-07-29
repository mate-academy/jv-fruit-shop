package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        this.operation = Operation.getByCode(operation);
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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String s) {
            for (Operation o : Operation.values()) {
                if (o.getCode().equals(s)) {
                    return o;
                }
            }
            throw new RuntimeException("This operation does not supported");
        }
    }
}
