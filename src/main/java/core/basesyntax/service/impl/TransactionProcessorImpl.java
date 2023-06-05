package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationHandlerStrategy handlerStrategy;

    public TransactionProcessorImpl(OperationHandlerStrategy handlerStrategy) {
        this.handlerStrategy = handlerStrategy;
    }

    @Override
    public void process(List<Transaction> fruitTransaction) {
        fruitTransaction.forEach(transaction -> {
            OperationHandler handler = handlerStrategy
                    .getOperationHandler(transaction.getOperation());
            handler.handler(transaction);
        });
    }
}
