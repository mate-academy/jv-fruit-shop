package core.basesyntax.service;
public class FruitTransaction {
    private String fruit;
    private int quantity;
    private Operation operation;

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
        String code;
        Operation(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }

    }
}
