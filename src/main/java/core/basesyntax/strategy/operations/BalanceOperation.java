package core.basesyntax.strategy.operations;

public class BalanceOperation implements DailyOperationHandler {
    @Override
    public int getQuantity(int quantity) {
        return quantity;
    }
}
