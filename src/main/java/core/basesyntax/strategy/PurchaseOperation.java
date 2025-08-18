package core.basesyntax.strategy;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getStock(int amount) {
        return -amount;
    }
}
