package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class TransactionStrategyReturnImpl implements TransactionStrategy{
    @Override
    public TransactionStrategy balanceUpdater(FruitTransaction.Operation operation) {
        return null;
    }
}
