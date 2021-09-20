package services.operations.strategy;

import java.util.Map;
import services.operations.Operation;

public class StrategyOperationsImpl implements StrategyOperations {
    private Map<String, Operation> strategyMap;

    public StrategyOperationsImpl(Map<String, Operation> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public Operation getOperation(String operation) {
        return strategyMap.get(operation);
    }
}
