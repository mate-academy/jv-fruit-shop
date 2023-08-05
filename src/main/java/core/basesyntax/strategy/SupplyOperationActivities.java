package core.basesyntax.strategy;

public class SupplyOperationActivities implements OperationActivities {
    @Override
    public int getOperation(int balance, int amount) {
        return balance + amount;
    }
}
