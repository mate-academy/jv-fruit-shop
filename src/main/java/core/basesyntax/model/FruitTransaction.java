package core.basesyntax.model;

public class FruitTransaction {
    private String operationType;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction() {
        this.operationType = operationType;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction(String operationType, Fruit fruit,
                            Integer quantity) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Fruit getTransactionFruitName() {
        return fruit;
    }

    public void setTransactionFruitName(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
