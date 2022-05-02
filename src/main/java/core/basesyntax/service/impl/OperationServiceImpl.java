package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final OperationStrategy operationStrategy;

    public OperationServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void executeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.operate(transaction);
        }
    }
}
