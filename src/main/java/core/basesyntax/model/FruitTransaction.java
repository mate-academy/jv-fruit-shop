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
        public static final String BALANCE_OPERATION = "b";
        public static final String SUPPLY_OPERATION = "s";
        public static final String PURCHASE_OPERATION = "p";
        public static final String RETURN_OPERATION = "r";

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation returnOperation(String codeOperation) {
            if (codeOperation.equals(BALANCE_OPERATION)) {
                return BALANCE;
            }
            if (codeOperation.equals(SUPPLY_OPERATION)) {
                return SUPPLY;
            }
            if (codeOperation.equals(PURCHASE_OPERATION)) {
                return PURCHASE;
            }
            if (codeOperation.equals(RETURN_OPERATION)) {
                return RETURN;
            }
            throw new IllegalArgumentException("Unknown operation code: " + codeOperation);
        }
    }
}
