package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationHandlerStrategy;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public FruitTransactionProcessorImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction -> {
            OperationHandler handler = operationHandlerStrategy
                    .getByOperation(fruitTransaction.operation());
            handler.handle(fruitTransaction);
        });
    }
}
