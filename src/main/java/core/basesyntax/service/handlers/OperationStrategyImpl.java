package core.basesyntax.service.handlers;

import core.basesyntax.model.Operation;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static Map<Operation, OperationHandler> operationHandlersMap = new HashMap<>() {{
            put(Operation.BALANCE, new BalanceOperationHandler());
            put(Operation.SUPPLY, new SupplyOperationHandler());
            put(Operation.PURCHASE, new PurchaseOperationHandler());
            put(Operation.RETURN, new ReturnOperationHandler());
        }};

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlersMap) {
        OperationStrategyImpl.operationHandlersMap = operationHandlersMap;
    }

    public static Map<Operation, OperationHandler> getOperationHandlersMap() {
        return operationHandlersMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlersMap.get(operation);
    }

}
