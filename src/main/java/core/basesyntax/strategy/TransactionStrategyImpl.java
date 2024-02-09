package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy{
    private Map<FruitTransaction.Operation, FruitTransaction> fruitTransactionMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, FruitTransaction> fruitTransactionMap) {
        this.fruitTransactionMap = fruitTransactionMap;
    }
    @Override
    public TransactionStrategy balanceUpdater(FruitTransaction.Operation operation) {
        return null;
    }
}
