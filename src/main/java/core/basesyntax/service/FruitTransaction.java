package core.basesyntax.service;

public class FruitTransaction {
    private FruitTransaction.Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(FruitTransaction.Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction.Operation getOperation() {
        return operation;
    }

    public static FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation value : FruitTransaction.Operation.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new RuntimeException("Incorrect name of operation");
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

    @Override
    public String toString() {
        return "{" + operation + ", " + fruit + ", " + quantity + "}";
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
    }
}
