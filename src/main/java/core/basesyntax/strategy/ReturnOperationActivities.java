package core.basesyntax.strategy;

public class ReturnOperationActivities implements OperationActivities {
    @Override
    public int getOperation(int balance, int amount) {
        return balance + amount;
    }
}
