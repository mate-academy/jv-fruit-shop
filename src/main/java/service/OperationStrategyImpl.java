package service;

import java.util.Map;
import model.FruitTransaction;
import service.storage.PerformingOperation;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,PerformingOperation> performingOperationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            PerformingOperation> performingOperationMap) {
        this.performingOperationMap = performingOperationMap;
    }

    @Override
    public PerformingOperation get(FruitTransaction.Operation code) {
        return performingOperationMap.get(code);
    }
}
