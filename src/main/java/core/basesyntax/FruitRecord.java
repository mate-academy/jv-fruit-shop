package core.basesyntax;

public class FruitRecord {
    private String operation;
    private String fruit;
    private int quantity;

    public FruitRecord(String operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public String getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
