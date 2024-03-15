package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Operation operation;

    public FruitTransaction(String fruit, int quantity, Operation operation) {
        this.fruit = fruit;
        this.quantity = quantity;
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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

        public static Operation fromCode(String code) {
            for (Operation element : values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
            throw new IllegalArgumentException("Can't find enum for code type operation: "
                    + "\""
                    + code
                    + "\"");
        }
    }

    @Override
    public String toString() {
        return "Operation type: "
                + operation
                + " |"
                + " FruitName: "
                + fruit
                + " |"
                + " Quantity fruit per operation = "
                + quantity;
    }
}

