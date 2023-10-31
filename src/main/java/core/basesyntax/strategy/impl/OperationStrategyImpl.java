package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void handleOperation(FruitTransaction fruitTransaction,
                                FruitStorageDao fruitStorageDao) {
        operationHandlerMap.get(fruitTransaction.getOperation())
                .operate(fruitTransaction.getFruit(),
                        fruitTransaction.getQuantity(), fruitStorageDao);
    }
}
