package fshop.service;

import fshop.service.strategy.StrategyPurchase;
import fshop.service.strategy.StrategyReturn;
import fshop.service.strategy.StrategySupply;

public class FoodService {
    private static final String COMA = ",";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public Integer selectStrategy(String operations, int valueFromDb) {
        if (operations.substring(0, operations.indexOf(COMA)).equals(PURCHASE)) {
            return new StrategyPurchase().execute(valueFromDb, getValueFromFile(operations));
        }
        if (operations.substring(0, operations.indexOf(COMA)).equals(RETURN)) {
            return new StrategyReturn().execute(valueFromDb, getValueFromFile(operations));
        }
        if (operations.substring(0, operations.indexOf(COMA)).equals(SUPPLY)) {
            return new StrategySupply().execute(valueFromDb, getValueFromFile(operations));
        }
        return -1;
    }

    private Integer getValueFromFile(String line) {
        return Integer.valueOf(line.substring(line.lastIndexOf(COMA) + 1));
    }
}
