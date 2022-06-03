package service;

import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private Map<Operation,AmountHandler> amountHandlersMap;

    public OperationHandlerStrategyImpl(Map<Operation, AmountHandler> amountHandlersMap) {
        this.amountHandlersMap = amountHandlersMap;
    }

    @Override
    public AmountHandler get(Operation operation) {
        return amountHandlersMap.get(operation);
    }
}
