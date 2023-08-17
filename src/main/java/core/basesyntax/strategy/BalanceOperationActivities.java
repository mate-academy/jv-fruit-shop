package core.basesyntax.strategy;

public class BalanceOperationActivities implements OperationActivities {
    @Override
    public int getOperation(int balance, int amount) {
        return balance + amount;
    }
}
