package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        this.operation = Operation.getByCode(operation);
        this.fruit = fruit;
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

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String s) {
            if (BALANCE.getCode().equals(s)) {
                return BALANCE;
            } else if (SUPPLY.getCode().equals(s)) {
                return SUPPLY;
            } else if (PURCHASE.getCode().equals(s)) {
                return PURCHASE;
            } else if (RETURN.getCode().equals(s)) {
                return RETURN;
            } else {
                throw new RuntimeException("Operation type not supported: " + s);
            }
        }
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
}
