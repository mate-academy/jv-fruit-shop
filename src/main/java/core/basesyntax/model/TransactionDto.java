package core.basesyntax.model;

public class TransactionDto {
    private String operation;
    private String fruitName;
    private int quantity;

    public TransactionDto(String operation, String fruitName, int quantiti) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantiti;
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
