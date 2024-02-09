package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class TransactionStrategySupplyImpl implements TransactionStrategy{


    @Override
    public TransactionStrategy balanceUpdater(FruitTransaction.Operation operation) {
        return null;
    }
}
