package strategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private OperationStrategy operationStrategy;

    @Override
    public void apply(Map<String, Integer> fruitCounts, String fruit, int quantity) {
        operationStrategy.apply(fruitCounts, fruit, quantity);
    }
}
