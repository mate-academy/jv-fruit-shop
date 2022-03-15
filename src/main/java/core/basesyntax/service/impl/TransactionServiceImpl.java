package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy operationStrategy;
    private final FruitTransaction fruitTransaction;

    public TransactionServiceImpl(OperationStrategy operationStrategy,
                                  FruitTransaction fruitTransaction) {
        this.operationStrategy = operationStrategy;
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public void doOperation() {
        operationStrategy.process(fruitTransaction.getOperationType(),
                fruitTransaction.getFruit());
    }
}
