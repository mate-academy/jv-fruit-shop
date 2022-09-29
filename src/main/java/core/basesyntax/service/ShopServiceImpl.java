package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.OperationsStrategyImpl;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationsStrategyImpl operationsStrategy;

    public ShopServiceImpl(Map<Operation, OperationHandler> operationOperationHandlerMap) {
        operationsStrategy = new OperationsStrategyImpl(operationOperationHandlerMap);
    }

    @Override
    public OperationHandler transaction(FruitTransaction fruitTransactions) {
        return operationsStrategy.chooseOperation(fruitTransactions.getOperation());
    }
}
