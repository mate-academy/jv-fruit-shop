package core.basesyntax.model;

public class FruitTransaction {
    private FruitTransactionOperation operation;
    private String fruit;
    private int quantity;

    public FruitTransactionOperation getOperation() {
        return operation;
    }

    public void setOperation(FruitTransactionOperation operation) {
        this.operation = operation;
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
}
