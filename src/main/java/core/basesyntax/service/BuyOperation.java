package core.basesyntax.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class BuyOperation implements FruitOperations {
    @Override
    public boolean operations(Map<String, Map<String, Integer>> store, FruitDto fruits) {
        String fruit = fruits.getFruit();
        Integer fruitQuantity = fruits.getQuantity();
        LocalDate fruitDate = LocalDate.parse(fruits.getDate());
        if (store.containsKey(fruit)) {
            Map<LocalDate, Integer> fruitSortedByData = getFilledMap(store, fruit);
            if (checkAvailableQuantity(fruitQuantity, fruitDate, fruitSortedByData)) {
                return false;
            }
            for (Map.Entry<LocalDate, Integer> entry : fruitSortedByData.entrySet()) {
                if (entry.getValue() >= fruitQuantity) {
                    store.get(fruit).put(entry.getKey().toString(),
                            entry.getValue() - fruitQuantity);
                    return true;
                }
                fruitQuantity -= entry.getValue();
                store.get(fruit).remove(entry.getKey().toString());
            }
        }
        return false;
    }

    private Map<LocalDate, Integer> getFilledMap(Map<String,
            Map<String, Integer>> store, String fruit) {
        Map<LocalDate, Integer> fruitsSortedByData = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : store.get(fruit).entrySet()) {
            fruitsSortedByData.put(LocalDate.parse(entry.getKey()), entry.getValue());
        }
        return fruitsSortedByData;
    }

    private boolean checkAvailableQuantity(Integer fruitQuantity, LocalDate fruitDate,
                                           Map<LocalDate, Integer> fruitsSortedByData) {
        return fruitsSortedByData.entrySet().stream()
                .filter(x -> x.getKey().isAfter(fruitDate))
                .mapToInt(Map.Entry::getValue)
                .sum() < fruitQuantity;
    }
}
