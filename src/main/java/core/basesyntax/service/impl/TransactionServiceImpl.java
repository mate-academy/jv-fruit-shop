package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(transaction -> {
            OperationHandler operationHandler
                    = operationStrategy.get(transaction.getOperation());
            operationHandler.handle(transaction);
        });
    }
}
