package core.basesyntax.strategy.operations;

public class PurchaseOperation implements DailyOperationHandler {
    @Override
    public int getQuantity(int quantity) {
        return quantity * (-1);
    }
}
