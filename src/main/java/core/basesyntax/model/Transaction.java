package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private String name;
    private int quantity;

    public Transaction(String operationCode, String name, int quantity) {
        this.operation = Operation.getByCode(operationCode);
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
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
