package core.basesyntax.model;

public class FruitTransaction {
    private String operation;
    private String fruitName;
    private int quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(String operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
