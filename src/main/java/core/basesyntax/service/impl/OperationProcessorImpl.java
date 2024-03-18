package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class OperationProcessorImpl implements TransactionProcessor {

    public void processTransactionList(List<FruitTransaction> list, HandlerStrategy strategy) {
        for (FruitTransaction transaction : list) {
            processTransaction(transaction, strategy);
        }
    }

    private void processTransaction(FruitTransaction transaction, HandlerStrategy strategy) {
        OperationHandler handler = strategy.getStrategy(transaction.getOperationType());
        String productType = transaction.getProductName();
        int amount = transaction.getAmount();
        handler.handleOperation(productType,amount);
    }
}
