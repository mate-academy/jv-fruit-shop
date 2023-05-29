package service.impl;

import java.util.Map;
import model.Fruit;
import strategy.FruitStrategy;
import strategy.OperationsStrategy;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<Fruit.Operation, OperationsStrategy> operationsStrategyMap;

    public FruitStrategyImpl(Map<Fruit.Operation, OperationsStrategy> operationsStrategyMap) {
        this.operationsStrategyMap = operationsStrategyMap;
    }

    @Override
    public OperationsStrategy get(Fruit.Operation operation) {
        return operationsStrategyMap.get(operation);
    }
}
