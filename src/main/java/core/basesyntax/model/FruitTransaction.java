package core.basesyntax.model;

public class FruitTransaction {
    private String name;
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation parseOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
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

        public static Operation getOperation(String operationCode) {
            for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
                if (operation.getCode().equals(operationCode)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + operationCode);
        }
    }

    public String getName() {
        return name;
    }
}
