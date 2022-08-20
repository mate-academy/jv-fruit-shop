package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategyImpl operationStrategy;

    public TransactionServiceImpl(OperationStrategyImpl operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> operationStrategy
                .getHandler(transaction.getOperation())
                .handle(transaction));
    }
}
