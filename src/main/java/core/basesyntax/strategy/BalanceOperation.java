package core.basesyntax.strategy;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getStock(int amount) {
        return amount;
    }
}
