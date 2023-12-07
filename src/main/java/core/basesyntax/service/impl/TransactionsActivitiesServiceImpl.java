package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsActivitiesService;
import core.basesyntax.strategy.OperationOption;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operationhandlers.OperationsHandler;

import java.util.List;

public class TransactionsActivitiesServiceImpl implements TransactionsActivitiesService {
    private final OperationStrategy operationStrategy;

    public TransactionsActivitiesServiceImpl(OperationOption operationStrategy) {
        this.operationStrategy = (OperationStrategy) operationStrategy;
    }

    @Override
    public void ActivityOfTransaction(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> {
            OperationsHandler operationHandler = operationStrategy.getHandler(transaction);
            operationHandler.handler(transaction);
        });
    }
}
