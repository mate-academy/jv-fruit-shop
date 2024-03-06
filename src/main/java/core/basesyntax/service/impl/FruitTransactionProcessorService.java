package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessorService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionProcessorService implements TransactionProcessorService {
    private final OperationStrategy operationStrategy;

    public FruitTransactionProcessorService(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        if (transactions.isEmpty()) {
            throw new RuntimeException("No transactions to process. Transaction list is empty!");
        }
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getOperationHandler(transaction.getOperation());
            operationHandler.performOperation(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
