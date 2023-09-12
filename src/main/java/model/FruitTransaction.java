package model;

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

    public String setFruit(String fruit) {
        this.fruit = fruit;
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private final String code;
        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String codeFromLine) {
            for (Operation type : Operation.values()) {
                if (type != null) {
                    if (codeFromLine.equals(type.getCode())) {
                        return type;
                    }
                }
            }
            throw new RuntimeException("This type of operation does not exist: " + codeFromLine);
        }
    }
}
