package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.FruitsCalculator;
import java.util.List;
import java.util.Map;

public class FruitsCalculatorImpl implements FruitsCalculator {
    private static final String REGEX = ",";

    @Override
    public Map<String, Integer> parseAndCalculate(List<String> data) {
        Map<String, Integer> fruitQuantities = DataBase.mapDb;
        for (String activityString : data) {
            String[] parts = activityString.split(REGEX);
            String type = parts[0];
            String fruitName = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            switch (type) {
                case "b":
                    fruitQuantities.put(fruitName, quantity);
                    break;
                case "s", "r":
                    fruitQuantities.put(fruitName, fruitQuantities.get(fruitName) + quantity);
                    break;
                case "p":
                    fruitQuantities.put(fruitName, fruitQuantities.get(fruitName) - quantity);
                    break;
                default:
                    throw new RuntimeException("Unexpected type " + type);
            }
        }
        return fruitQuantities;
    }
}
