package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategyOperations;

    public ShopServiceImpl(OperationStrategy strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> fruitsList) {
        if (fruitsList.isEmpty()) {
            throw new RuntimeException("Empty list!");
        }
        Map<String, Integer> currentMap;
        Map<String, Integer> fruitsMap = new HashMap<>();

        for (FruitTransaction fruit : fruitsList) {
            if (fruit.getFruit() == null) {
                throw new RuntimeException("Fruit is null");
            }
            currentMap = strategyOperations.get(fruit.getOperation())
                    .getCalculation(fruitsMap, fruit);
            fruitsMap.putAll(currentMap);
        }
        return fruitsMap;
    }
}
