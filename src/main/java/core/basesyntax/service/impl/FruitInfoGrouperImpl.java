package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitInfoGrouper;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitInfoGrouperImpl implements FruitInfoGrouper {
    private Map<String, OperationStrategy> operationStrategyMap;

    public FruitInfoGrouperImpl(Map<String, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public Map<String, Integer> groupFruitsInfo(List<Fruit> convertedFruits) {
        Map<String, Integer> resultReport = new HashMap<>();
        for (int i = 0; i < convertedFruits.size(); i++) {
            Fruit fruit = convertedFruits.get(i);
            if (resultReport.containsKey(fruit.getName())) {
                Integer value = operationStrategyMap
                        .get(String.valueOf(fruit.getType()))
                        .getAmount(fruit.getAmount());
                resultReport.put(fruit.getName(),
                        value + resultReport.get(fruit.getName()));
            } else {
                resultReport.put(fruit.getName(), fruit.getAmount());
            }
        }
        return resultReport;
    }
}
