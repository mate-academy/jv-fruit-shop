package core.basesyntax.model;

public class FruitRecord {
    private final Operation operation;
    private final String fruitName;
    private final int balance;

    public FruitRecord(Operation operation, String fruitName, int balance) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "FruitRecord{"
                + "operation=" + operation
                + ", fruit='" + fruitName + '\''
                + ", balance=" + balance
                + '}';
    }
}
