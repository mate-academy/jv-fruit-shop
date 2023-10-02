package core.basesyntax.model;

public class FruitsTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    @Override
    public String toString() {
        return "FruitsTransaction{" + "operation=" + operation + ", fruit='" + fruit + '\'' + ", "
                + "quantity=" + quantity + '}';
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
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOption(String option) {
            for (Operation operation : Operation.values()) {
                if (operation.code.equals(option)) {
                    return operation;
                }
            }
            throw new RuntimeException("Unknown operation!");
        }
    }
}



