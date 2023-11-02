package core.basesyntax.transaction;

public class FruitTransaction {
    private static final String INVALID_OPERATION_MESSAGE = "The provided operation code "
            + "is invalid: ";
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
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getOperation(String code) {
            switch (code) {
                case "b":
                    return BALANCE;
                case "s":
                    return SUPPLY;
                case "p":
                    return PURCHASE;
                case "r":
                    return RETURN;
                default:
                    throw new RuntimeException(INVALID_OPERATION_MESSAGE + code);
            }
        }

        public String getCode() {
            return code;
        }
    }
}
