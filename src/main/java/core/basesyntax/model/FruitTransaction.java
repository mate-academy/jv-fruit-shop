package core.basesyntax.model;

public class FruitTransaction extends Fruit {
    private Operation operation;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

        public static Operation getByOperationType(String type) {
            for (Operation operation : values()) {
                if (operation.getCode().equals(type)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No enum constant found with operations " + type);
        }

        public String getCode() {
            return code;
        }
    }
}
