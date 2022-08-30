package core.strategy;

import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<String, OperationHandler> map;

    public FruitStrategyImpl(Map<String, OperationHandler> map) {
        this.map = map;
    }

    public Map<String, OperationHandler> getMap() {
        return map;
    }

    @Override
    public OperationHandler getByOperation(String operation) {
        return map.get(operation);
    }
}
