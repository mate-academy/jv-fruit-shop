package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.services.operation.AddOperationHandlerImpl;
import core.basesyntax.services.operation.OperationHandler;
import core.basesyntax.services.operation.PurchaseOperationHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("r", new AddOperationHandlerImpl(new FruitStorageDaoImpl()));
        operationHandlerMap.put("p", new PurchaseOperationHandlerImpl(new FruitStorageDaoImpl()));
        operationHandlerMap.put("b", new AddOperationHandlerImpl(new FruitStorageDaoImpl()));
        operationHandlerMap.put("s", new AddOperationHandlerImpl(new FruitStorageDaoImpl()));
    }

    @Override
    public OperationHandler get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
