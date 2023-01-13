package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.StorageUpdateService;
import core.basesyntax.service.amount.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class StorageUpdateServiceImpl implements StorageUpdateService {
    private OperationStrategy strategy;

    public StorageUpdateServiceImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.strategy = new OperationStrategyImpl(operationHandlerMap);
    }

    @Override
    public void update(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler operation = strategy.getOperationHandler(transaction.getOperation());
            operation.process(transaction);
        }
    }
}
