package core.basesyntax.model;

public class FruitTransaction {
    private FruitOperation fruitOperation;
    private String fruitName;
    private int quantity;

    public FruitTransaction(FruitOperation fruitOperation, String fruitName, int quantity) {
        this.fruitOperation = fruitOperation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public FruitOperation getFruitOperation() {
        return fruitOperation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
