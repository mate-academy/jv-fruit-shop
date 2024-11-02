package core.basesyntax.model;

public class FruitTransaction {
    private Operation type;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getType() {
        return type;
    }

    public void setType(Operation type) {
        this.type = type;
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

        public String getCode() {
            return code;
        }

        public static boolean startWithOperation(String line) {
            for (Operation operation : Operation.values()) {
                if (line.startsWith(operation.getCode())) {
                    return true;
                }
            }
            return false;
        }

        public static Operation convertToOperaion(String data) {
            for (Operation operation : Operation.values()) {
                if (data.equals(operation.getCode())) {
                    return operation;
                }
            }
            throw new RuntimeException("Unknown operation code: " + data);
        }
    }
}
