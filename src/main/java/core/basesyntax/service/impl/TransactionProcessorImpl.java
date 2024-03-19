package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void processTransactionList(
            List<FruitTransaction> transactionList,
            OperationHandler operationHandler
    ) {
        for (FruitTransaction transaction : transactionList) {
            OperationStrategy handler = operationHandler.getStrategy(transaction.operation());
            String product = transaction.fruit();
            int quantity = transaction.quantity();
            handler.process(product, quantity);
        }
    }
}
