package model;

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

        public static FruitTransaction.Operation validation(String codeOperation) {
            Operation[] values = Operation.values();
            for (int i = 0; i < Operation.values().length; i++) {
                if (values[i].getCode().equals(codeOperation)) {
                    return values[i];
                }
            }
            throw new RuntimeException("Can't parse this Operation " + codeOperation);
        }

        public String getCode() {
            return code;
        }

    }
}
