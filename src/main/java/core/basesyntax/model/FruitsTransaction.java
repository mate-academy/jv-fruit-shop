package core.basesyntax.model;

public class FruitsTransaction {
    private Operation operation;
    private String name;
    private int quantity;

    public FruitsTransaction(String operationCode, String name, int quantity) {
        this.operation = Operation.getByCode(operationCode);
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getName() {
        return name;
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

        public static Operation getByCode(String operationCode) {
            for (Operation operation : Operation.values()) {
                if (operation.code.equals(operationCode)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + operationCode);
        }
    }
}
