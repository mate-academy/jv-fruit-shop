package service.strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import service.operations.OperationsHandler;
import service.strategy.OperationsStrategy;

public class OperationsStrategyImpl implements OperationsStrategy {
    private Map<FruitTransaction.Operation, OperationsHandler> operationOperationsHandlerMap;

    public OperationsStrategyImpl(Map<FruitTransaction.Operation,
            OperationsHandler> operationOperationsHandlerMap) {
        this.operationOperationsHandlerMap = operationOperationsHandlerMap;
    }

    @Override
    public OperationsHandler get(FruitTransaction.Operation operation) {
        return operationOperationsHandlerMap.get(operation);
    }
}
