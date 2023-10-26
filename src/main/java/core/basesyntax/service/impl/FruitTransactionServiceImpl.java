package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private OperationStrategy strategy;

    public FruitTransactionServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        strategy.get(fruitTransaction.getOperation()).handle(fruitTransaction);
    }
}
