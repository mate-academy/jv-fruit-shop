package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class OperationProcessorImpl implements TransactionProcessor {
    private final HandlerStrategy strategy;

    public OperationProcessorImpl(HandlerStrategy strategy) {
        this.strategy = strategy;
    }

    public void process(List<FruitTransaction> list) {
        for (FruitTransaction transaction : list) {
            processSingleTransaction(transaction);
        }
    }

    private void processSingleTransaction(FruitTransaction transaction) {
        OperationHandler handler = strategy.getHandlerByOperation(transaction.getOperationType());
        String productType = transaction.getProductName();
        int amount = transaction.getAmount();
        handler.handle(productType, amount);
    }
}
