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
        if (transactions.size() == 0) {
            throw new RuntimeException("CSV file is empty!");
        } else {
            for (FruitTransaction transaction: transactions) {
                operationStrategy.get(transaction.getOperation()).handle(transaction);
            }
        }
    }
}
