package core.basesyntax.services.operations;

import core.basesyntax.services.FruitDto;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class PurchaseOperation implements Operable {

    @Override
    public boolean updateStorage(Map<String, Map<String, Integer>> store, FruitDto dto) {
        String buyingFruit = dto.getFruitName();
        int buyingCount = dto.getCount();
        LocalDate buyingDate = LocalDate.parse(dto.getData());
        if (store.containsKey(buyingFruit)) {
            Map<LocalDate, Integer> fruitsSortedByData
                    = getFilledMap(store, buyingFruit);
            if (checkAvailableQuantity(buyingCount, buyingDate,
                    fruitsSortedByData)) {
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

    private Map<LocalDate, Integer> getFilledMap(Map<String, Map<String, Integer>> store,
                                                 String buyingFruit) {
        Map<LocalDate, Integer> fruitsSortedByData = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : store.get(buyingFruit).entrySet()) {
            fruitsSortedByData.put(LocalDate.parse(entry.getKey()),
                    entry.getValue());
        }
        return fruitsSortedByData;
    }

    private boolean checkAvailableQuantity(int buyingCount, LocalDate buyingDate,
                                           Map<LocalDate, Integer> fruitsSortedByData) {
        return fruitsSortedByData.entrySet().stream()
                .filter(e -> e.getKey().isAfter(buyingDate))
                .mapToInt(Map.Entry::getValue)
                .sum() < buyingCount;
    }
}
