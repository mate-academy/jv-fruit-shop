package core.basesyntax.strategy;

public class BalanceOperation implements OperationHandler {
    @Override
    public int apply(int currentQuantity, int transactionQuantity) {
        return transactionQuantity;
    }
}
