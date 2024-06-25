package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruitName;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public final Operation getOperation() {
        return operation;
    }

    public final String getFruitName() {
        return fruitName;
    }

    public final int getQuantity() {
        return quantity;
    }
}
