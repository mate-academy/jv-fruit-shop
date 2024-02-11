package core.basesyntax.model;

public class FruitTransaction {
    private String operation;
    private String fruitName;
    private int quantity;

    public FruitTransaction(String operation, String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.operation = operation;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }
}
