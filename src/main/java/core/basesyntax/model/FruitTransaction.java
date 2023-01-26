package core.basesyntax.model;

public class FruitTransaction {
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

    public Operation getOperationByCode(String code) {
        for (Operation operationType : Operation.values()) {
            if (operationType.code.equals(code)) {
                return operationType;
            }
        }
        throw new RuntimeException("Couldn't find operation for this characrter " + code);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String operation) {
            this.code = operation;
        }

        public String getOperation() {
            return code;
        }
    }
}
