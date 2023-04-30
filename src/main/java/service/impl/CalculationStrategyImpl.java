package service.impl;

import java.util.Map;
import model.Operation;
import service.CalculationStrategy;
import service.OperationHandler;

public class CalculationStrategyImpl implements CalculationStrategy {
    private Map<Operation, OperationHandler> calculationHandlerMap;

    public CalculationStrategyImpl(Map<Operation, OperationHandler> calculationHandlerMap) {
        this.calculationHandlerMap = calculationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return calculationHandlerMap.get(operation);
    }
}
