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

        public static Operation convertToOperation(String data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            for (Operation operation : Operation.values()) {
                if (data.equals(operation.getCode())) {
                    return operation;
                }
            }

            throw new UnknownOperationException("Unknown operation code" + data);
        }
    }
}
