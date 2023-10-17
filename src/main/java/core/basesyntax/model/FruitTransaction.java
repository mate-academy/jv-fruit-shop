package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Operation operation;

    public String getFruit() {
        return fruit;
    }

    public void subtract(int quantity) {
        this.quantity -= quantity;
    }

    public void add(int quantity) {
        this.quantity += quantity;
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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = Operation.getOperationFromString(operation);
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

        public static Operation getOperationFromString(String code) {
            for (Operation op : Operation.values()) {
                if (code.equals(op)) {
                    return op;
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

    }
}
