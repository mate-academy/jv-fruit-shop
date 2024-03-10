package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.IOperationStrategy;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.IOperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.ReturnOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy implements IOperationStrategy {
    private final Map<Operation, IOperationHandler> operationHandlerMap;

    public OperationStrategy() {
        this.operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
    }

    @Override
    public IOperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
