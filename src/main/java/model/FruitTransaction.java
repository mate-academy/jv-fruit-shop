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

    public enum Operation {
        BALANCE("b"),
        PURCHASE("p"),
        SUPPLY("s"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String operationCode) {
            for (Operation o : Operation.values()) {
                if (o.getCode().equals(operationCode)) {
                    return o;
                }
            }
            throw new RuntimeException("Operation code is not supported: " + operationCode);
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
