package service;

import java.util.Map;
import model.FruitTransaction;
import service.operation.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> performingOperationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> performingOperationMap) {
        this.performingOperationMap = performingOperationMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation code) {
        return performingOperationMap.get(code);
    }
}
