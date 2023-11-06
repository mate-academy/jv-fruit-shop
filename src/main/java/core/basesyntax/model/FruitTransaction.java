package core.basesyntax.model;

public class FruitTransaction {
    private static final String EXCEPTION_MESSAGE = "No such Operation!";
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

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

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;
        Operation(String code) {
            this.code = code;
        }

        public static Operation getOperationByCode(String code) {
            Operation[] values = Operation.values();
            for (Operation operation : values) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }

        public String getCode() {
            return code;
        }
    }
}
