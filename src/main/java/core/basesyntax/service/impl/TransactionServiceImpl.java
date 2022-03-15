package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;

public class TransactionServiceImpl implements TransactionService {
    private static final OperationStrategy OPERATION_STRATEGY =
            new OperationStrategyImpl(new OperationHandlerProvider().getOperationHandlers());
    private final FruitTransaction fruitTransaction;

    public TransactionServiceImpl(FruitTransaction fruitTransaction) {
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public void doOperation() {
        OPERATION_STRATEGY.process(fruitTransaction.getOperationType(),
                fruitTransaction.getFruit());
    }
}
