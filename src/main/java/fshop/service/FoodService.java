package fshop.service;

import fshop.service.strategy.Strategy;
import fshop.service.strategy.StrategyPurchase;
import fshop.service.strategy.StrategyReturn;
import fshop.service.strategy.StrategySupply;
import java.util.HashMap;
import java.util.Map;

public class FoodService {
    private static final String COMA = ",";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private Map<String, Strategy> mapWithStrategies;

    public FoodService() {
        mapWithStrategies = new HashMap<>();
        addAllStrategies();
    }

    public Integer selectStrategy(String operations, int valueFromDb) {
        String newOperations = operations.substring(0, operations.indexOf(COMA));
        Strategy resultFromMap = mapWithStrategies.get(newOperations);
        if (resultFromMap != null) {
            return mapWithStrategies.get(newOperations)
                    .execute(valueFromDb, getValueFromFile(operations));
        }
        return -1;
    }

    private Integer getValueFromFile(String line) {
        return Integer.valueOf(line.substring(line.lastIndexOf(COMA) + 1));
    }

    private void addAllStrategies() {
        mapWithStrategies.put(PURCHASE, new StrategyPurchase());
        mapWithStrategies.put(RETURN, new StrategyReturn());
        mapWithStrategies.put(SUPPLY, new StrategySupply());
    }
}
