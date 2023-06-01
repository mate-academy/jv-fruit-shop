package core.basesyntax.model;

public class FruitModel {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitModel(Operation operation, String fruit, int quantity) {
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getOperation(String code) {
            for (Operation operation : Operation.values()) {
                if (code.equals(operation.getCode())) {
                    return operation;
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }
    }
}
