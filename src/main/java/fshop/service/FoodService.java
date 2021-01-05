package fshop.service;

import fshop.service.strategy.StrategyImpl;
import fshop.service.strategy.StrategyPurchase;
import fshop.service.strategy.StrategyReturn;
import fshop.service.strategy.StrategySupply;

public class FoodService {
    private static final String COMA = ",";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public Integer selectStrategy(String operations, int valueFromDb) {
        StrategyImpl strategy = new StrategyImpl();
        if (operations.substring(0, operations.indexOf(COMA)).equals(PURCHASE)) {
            strategy.setStrategy(new StrategyPurchase());
            return strategy.execute(valueFromDb, getValueFromFile(operations));
        }
        if (operations.substring(0, operations.indexOf(COMA)).equals(RETURN)) {
            strategy.setStrategy(new StrategyReturn());
            return strategy.execute(valueFromDb, getValueFromFile(operations));
        }
        if (operations.substring(0, operations.indexOf(COMA)).equals(SUPPLY)) {
            strategy.setStrategy(new StrategySupply());
            return strategy.execute(valueFromDb, getValueFromFile(operations));
        }
        return -1;
    }

    private Integer getValueFromFile(String line) {
        return Integer.valueOf(line.substring(line.lastIndexOf(COMA) + 1));
    }
}
