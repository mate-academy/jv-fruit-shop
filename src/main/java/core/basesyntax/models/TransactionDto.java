package core.basesyntax.models;

public final class TransactionDto {
    private final String operation;
    private final String fruitName;
    private final int quantity;

    public TransactionDto(String operation, String fruitName, int number) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = number;
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
