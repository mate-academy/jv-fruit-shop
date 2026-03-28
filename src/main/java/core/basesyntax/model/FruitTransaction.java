package core.basesyntax.model;

public class FruitTransaction {

    private int quantity;
    private String fruit;
    private Operation operation;

    public FruitTransaction(int quantity, String fruit, Operation operation) {
        this.quantity = quantity;
        this.fruit = fruit;
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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
