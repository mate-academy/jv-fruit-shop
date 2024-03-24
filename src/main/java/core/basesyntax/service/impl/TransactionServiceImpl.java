package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy strategy;

    public TransactionServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processData(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.get(transaction.getOperation()).getOperation(transaction);
        }
    }
}
