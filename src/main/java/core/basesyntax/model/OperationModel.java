package core.basesyntax.model;

public class OperationModel {
    private Operation operation;
    private FruitModel fruit;
    private int amount;

    public OperationModel(Operation operation, FruitModel fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public FruitModel getFruit() {
        return fruit;
    }

    public void setFruit(FruitModel fruit) {
        this.fruit = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setQuantity(int quantity) {
        this.amount = quantity;
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

        public static Operation getOperationFromCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid operation type " + code);
        }
    }
}
