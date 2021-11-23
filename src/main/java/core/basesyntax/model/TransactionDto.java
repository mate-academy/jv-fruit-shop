package core.basesyntax.model;

public class TransactionDto {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public TransactionDto(Operation operation, String fruitName, int quantity) {
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
}
