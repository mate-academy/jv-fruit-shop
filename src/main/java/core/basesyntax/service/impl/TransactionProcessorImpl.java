package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;

public class TransactionProcessorImpl implements TransactionProcessor {
    private HandlerStrategy handlerStrategy;

    public TransactionProcessorImpl(HandlerStrategy handlerStrategy) {
        this.handlerStrategy = handlerStrategy;
    }

    @Override
    public void processTransaction(FruitTransaction transaction, HandlerStrategy handlerStrategy) {
        OperationHandler newHandler = handlerStrategy.getHandlerByOperationType(
                transaction.getOperationType());
        String fruitName = transaction.getFruitName();
        int amount = transaction.getQuantity();
        newHandler.processTransaction(fruitName, amount);
    }
}
