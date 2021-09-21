package core.basesyntax.model;

import java.util.Objects;

public class TransactionDto {
    private OperationType operationType;
    private Fruit fruitName;
    private int amount;

    public Fruit getFruitName() {
        return fruitName;
    }

    public void setFruitName(Fruit fruitName) {
        this.fruitName = fruitName;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object transaction) {
        if (this == transaction) {
            return true;
        }
        if (transaction == null) {
            return false;
        }
        TransactionDto transactionDto = (TransactionDto) transaction;
        return getAmount() == transactionDto.getAmount()
                && getOperationType() == transactionDto.getOperationType()
                && Objects.equals(getFruitName(), transactionDto.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperationType(), getFruitName(), getAmount());
    }

    @Override
    public String toString() {
        return "operation type: " + operationType
                + " fruit name: " + fruitName
                + " amount: " + amount;
    }
}
