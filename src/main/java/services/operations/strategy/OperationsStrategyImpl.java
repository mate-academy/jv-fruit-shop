package services.operations.strategy;

import java.util.Map;
import services.operations.Operation;

public class OperationsStrategyImpl implements OperationsStrategy {
    private Map<String, Operation> strategyMap;

    public OperationsStrategyImpl(Map<String, Operation> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public Operation getOperation(String operation) {
        return strategyMap.get(operation);
    }
}
