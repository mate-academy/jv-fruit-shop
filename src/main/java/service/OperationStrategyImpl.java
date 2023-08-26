package service;

import java.util.Map;
import service.storage.PerformingOperation;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String,PerformingOperation> performingOperationMap;

    public OperationStrategyImpl(Map<String, PerformingOperation> performingOperationMap) {
        this.performingOperationMap = performingOperationMap;
    }

    @Override
    public PerformingOperation get(String code) {
        return performingOperationMap.get(code);
    }
}
