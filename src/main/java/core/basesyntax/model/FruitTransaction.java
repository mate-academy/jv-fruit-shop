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

        private String code;
        Operation(String code) {
            this.code = code;
        }

        public static Operation getByCode(String code) {
            Operation[] operations = Operation.values();
            for (Operation operation : operations) {
                if (operation.code.equals(code)) {
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
