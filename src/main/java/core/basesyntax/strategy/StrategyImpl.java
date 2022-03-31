package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.operation.AddOperationHandlerImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("r", new AddOperationHandlerImpl(new StorageDaoImpl()));
        operationHandlerMap.put("p", new PurchaseOperationHandlerImpl(new StorageDaoImpl()));
        operationHandlerMap.put("b", new AddOperationHandlerImpl(new StorageDaoImpl()));
        operationHandlerMap.put("s", new AddOperationHandlerImpl(new StorageDaoImpl()));
    }

    @Override
    public OperationHandler get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
