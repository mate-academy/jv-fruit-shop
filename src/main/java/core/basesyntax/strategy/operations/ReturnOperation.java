package core.basesyntax.strategy.operations;

public class ReturnOperation implements DailyOperationHandler {
    @Override
    public int getQuantity(int quantity) {
        return quantity;
    }
}
