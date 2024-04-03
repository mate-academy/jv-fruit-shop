package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.database.FruitActivity;
import core.basesyntax.service.CalculateFruits;
import java.util.List;
import java.util.Map;

public class CalculateFruitsImpl implements CalculateFruits {
    private final DataBase dataBase = new DataBase();
    private final Map<String, Integer> map = dataBase.getDb();

    @Override
    public Map<String, Integer> calculate(List<FruitActivity> activities) {
        for (FruitActivity activity : activities) {
            switch (activity.getOperation()) {
                case "b":
                    map.put(activity.getFruit(), activity.getQuantity());
                    break;
                case "s":
                    map.put(activity.getFruit(),
                            map.getOrDefault(activity.getFruit(), 0) + activity.getQuantity());
                    break;
                case "p":
                    map.put(activity.getFruit(),
                            map.getOrDefault(activity.getFruit(), 0) - activity.getQuantity());
                    break;
                case "r":
                    map.put(activity.getFruit(),
                            map.getOrDefault(activity.getFruit(), 0) + activity.getQuantity());
                    break;
                default:
                    throw new RuntimeException("Unknown activity: " + activity.getOperation());
            }
        }
        return map;
    }
}
