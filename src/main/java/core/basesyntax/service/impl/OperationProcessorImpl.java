package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;

public class OperationProcessorImpl implements TransactionProcessor {

    @Override
    public void processTransaction(FruitTransaction transaction, HandlerStrategy handlerStrategy) {
        OperationHandler handler = handlerStrategy.getStrategy(transaction.getOperationType());
        String productName = transaction.getProductName();
        int amount = transaction.getAmount();
        handler.handleOperation(productName,amount);
    }
}
