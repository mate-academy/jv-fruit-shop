package model;

public class FruitTransaction {
    // Fields: operation, fruit, quantity; getters, setters
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getOperation() {
            return code;
        }

        public Operation getOperationType() {
            return this;
        }

        public static Operation fromCode(String str) {
            for (Operation value : values()) {
                if (value.code.equalsIgnoreCase(str)) {
                    return value;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + str);
        }

    }
}
