package core.basesyntax.service.operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String,OperationHandler> operationHandlesMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlesMap) {
        this.operationHandlesMap = operationHandlesMap;
    }

    @Override
    public OperationHandler get(String operation) {
        operationHandlesMap.put("s",new SupplyOperationHandler());
        operationHandlesMap.put("p",new PurchaseOperationHandler());
        operationHandlesMap.put("r",new ReturnOperationHandler());
        operationHandlesMap.put("b",new BalanceOperationHandler());
        OperationHandler result = operationHandlesMap.get(operation) == null
                ? new IncorrectOperationHandler() : operationHandlesMap.get(operation);
        return result;
    }
}
