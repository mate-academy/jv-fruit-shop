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

        public static Operation getOperationByCode(String code) {
            for (Operation operationType : Operation.values()) {
                if (operationType.code.equals(code)) {
                    return operationType;
                }
            }
            throw new RuntimeException("Incorrect code: " + code);
        }

    }
}
