package core.basesyntax.fruittransaction;

public class FruitTransaction {
    private final Operation operation;
    private final String fruitName;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return System.lineSeparator()
                + "FruitTransaction{"
                + "operation="
                + operation
                + ", fruitName='"
                + fruitName
                + '\''
                + ", quantity="
                + quantity
                + '}';
    }
}
