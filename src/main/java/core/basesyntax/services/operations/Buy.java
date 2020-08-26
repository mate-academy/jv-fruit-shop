package core.basesyntax.services.operations;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Buy implements Operable {

    @Override
    public boolean operate(Map<String, Map<String, Integer>> store, String[] data) {
        String buyingFruit = data[1];
        int buyingCount = Integer.parseInt(data[2]);
        LocalDate buyingDate = LocalDate.parse(data[3]);
        if (store.containsKey(buyingFruit)) {
            Map<LocalDate, Integer> fruitsSortedByData = new TreeMap<>();
            for (Map.Entry<String, Integer> entry : store.get(buyingFruit).entrySet()) {
                fruitsSortedByData.put(LocalDate.parse(entry.getKey()),
                        entry.getValue());
            }
            if (fruitsSortedByData.entrySet().stream()
                    .filter(e -> e.getKey().isAfter(buyingDate))
                    .mapToInt(Map.Entry::getValue)
                    .sum()
                    < buyingCount) {
                return false;
            }
            for (Map.Entry<LocalDate, Integer> entry : fruitsSortedByData.entrySet()) {
                if (entry.getValue() >= buyingCount) {
                    store.get(buyingFruit).put(entry.getKey().toString(),
                            entry.getValue() - buyingCount);
                    return true;
                }
                buyingCount -= entry.getValue();
                store.get(buyingFruit).remove(entry.getKey().toString());
            }
        }
        return false;
    }
}
