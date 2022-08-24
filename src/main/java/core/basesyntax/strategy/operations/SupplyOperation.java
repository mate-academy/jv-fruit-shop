package core.basesyntax.strategy.operations;

public class SupplyOperation implements DailyOperationHandler {
    @Override
    public int getQuantity(int quantity) {
        return quantity;
    }
}
