package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, String quantity) {
        this.operation = Operation.getByCode(operation);
        this.fruit = fruit;
        this.quantity = Integer.parseInt(quantity);
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String code) {

            if (code == null || code.isEmpty()) {
                throw new IllegalArgumentException("Code cannot be null or empty");
            }

            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }

            throw new IllegalArgumentException("Unknown operation code: " + code);
        }
    }
}
