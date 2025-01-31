package model;

public class FruitTransaction extends Fruit {
    private Operation operation;

    public FruitTransaction(String fruit, int quantity,Operation operation) {
        setOperation(operation);
        setFruit(fruit);
        setQuantity(quantity);
    }

    public FruitTransaction(String fruit, int quantity) {
        setFruit(fruit);
        setQuantity(quantity);
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

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation fromCode(String code) {
            for (Operation type : Operation.values()) {
                if (type.operation.equalsIgnoreCase(code)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown transaction type: " + code);
        }
    }
}
