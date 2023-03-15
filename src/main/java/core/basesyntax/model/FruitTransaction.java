package core.basesyntax.model;

public class FruitTransaction {
    private int quantity;
    private Operation operation;
    private String fruit;

    public FruitTransaction(int quantity, Operation operation, String fruit) {
        this.quantity = quantity;
        this.operation = operation;
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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

    public enum Operation {
        BALANCE("b"),
        EXPIRED("e"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperation(String operationCode) {
            for (Operation o : Operation.values()) {
                if (o.getCode().equals(operationCode)) {
                    return o;
                }
            }
            throw new RuntimeException("Cannot find this operation: " + operationCode);
        }
    }
}
