package core.model;

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

    public enum Operation {
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getByCode(String code) {
            for (Operation each : values()) {
                if (each.operation.equals(code)) {
                    return each;
                }
            }
            throw new RuntimeException("Code " + code + " is not supported");
        }
    }
}
