package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class TransactionStrategyPurchaseImpl implements TransactionStrategy{
    @Override
    public TransactionStrategy balanceUpdater(FruitTransaction.Operation operation) {
        return null;
    }
}
