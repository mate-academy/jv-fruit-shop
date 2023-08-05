package core.basesyntax.strategy;

public class PurchaseOperationActivities implements OperationActivities {
    @Override
    public int getOperation(int balance, int amount) {
        return balance - amount;
    }
}
