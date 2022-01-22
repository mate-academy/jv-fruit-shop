package core.basesyntax.model;

import core.basesyntax.strategy.OperationType;

public class TransactionDto {
    private OperationType operation;
    private String fruitName;
    private int quantity;

    public TransactionDto(OperationType operation, String fruitName, int quantiti) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantiti;
    }

    public OperationType getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
