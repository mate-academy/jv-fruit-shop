package service.impl;

import java.util.Map;
import model.Operation;
import service.CalculationStrategy;
import service.FruitCalculation;

public class CalculationStrategyImpl implements CalculationStrategy {
    private Map<Operation, FruitCalculation> calculationHandlerMap;

    public CalculationStrategyImpl(Map<Operation, FruitCalculation> calculationHandlerMap) {
        this.calculationHandlerMap = calculationHandlerMap;
    }

    @Override
    public FruitCalculation get(Operation operation) {
        return calculationHandlerMap.get(operation);
    }
}
