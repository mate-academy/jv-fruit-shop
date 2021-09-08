package core.basesyntax.model;

import java.util.NoSuchElementException;

public class FruitRecord {
    private final Operation operation;
    private final String fruitName;
    private final int amount;

    public FruitRecord(Operation operation, String fruitName, int amount) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "FruitRecord{" +
                "operation=" + operation +
                ", fruitName='" + fruitName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static Operation getOperationByFirstLetter(char symbol) {
        switch (symbol) {
            case 'b': return Operation.BALANCE;
            case 'p': return Operation.PURCHASE;
            case 'r': return Operation.RETURN;
            case 's': return Operation.SUPPLY;
        }
        throw new NoSuchElementException("There isn't such operation for fruit shop.");
    }

    public enum Operation {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN;
    }
}
