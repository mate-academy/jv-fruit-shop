package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
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
        for (FruitTransaction e : fruitTransactions) {
            if (Storage.fruits.containsKey(e.getFruitType())) {
                OperationHandler operation = strategy.getOperationImpl(e.getOperation());
                operation.process(e);
            } else {
                Storage.fruits.put(e.getFruitType(), e.getAmount());
            }
        }
    }
}
