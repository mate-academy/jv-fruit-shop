package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategyImpl operationStrategy;

    public TransactionServiceImpl(OperationStrategyImpl operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void doOperationService(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operationStrategy
                .getHandler(t.getOperation())
                .operationWithFruitTransaction(t));
    }
}
