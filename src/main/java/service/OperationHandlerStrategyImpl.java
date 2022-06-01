package service;

import java.util.Map;

public class AmountStrategyImpl implements AmountStrategy {
    private Map<Operation,AmountHandler> amountHandlersMap;

    public AmountStrategyImpl(Map<Operation, AmountHandler> amountHandlersMap) {
        this.amountHandlersMap = amountHandlersMap;
    }

    @Override
    public AmountHandler get(Operation operation) {
        return amountHandlersMap.get(operation);
    }
}
