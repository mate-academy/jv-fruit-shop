package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(String operationCode, Fruit fruit, int quantity) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(operationCode)) {
                this.operation = operation;
            }
        }
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
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
    }
}
