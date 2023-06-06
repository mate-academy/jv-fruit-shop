package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            operationStrategy.get(transaction.getOperation()).handle(transaction);
        }
    }
}
