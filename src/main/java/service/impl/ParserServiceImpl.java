package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    public static final int ACTIVITY_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public Map<String, Integer> parseData(List<String> dataFromFile) {
        Map<String, Integer> fruitQuantities = new HashMap<>();
        for (String str : dataFromFile) {
            String[] parts = str.split(",");
            String activity = parts[ACTIVITY_INDEX];
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            switch (activity) {
                case "b" -> fruitQuantities.put(fruit, quantity);
                case "s", "r" -> fruitQuantities
                        .put(fruit, fruitQuantities.getOrDefault(fruit, 0) + quantity);
                case "p" -> fruitQuantities
                        .put(fruit, fruitQuantities.getOrDefault(fruit, 0) - quantity);
                default -> {
                }
            }
        }
        return fruitQuantities;
    }
}
