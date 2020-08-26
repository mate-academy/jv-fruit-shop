package core.basesyntax.items;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private Map<String, Map<LocalDate, Integer>> storage = new TreeMap<>();

    public Map<LocalDate, Integer> getBoxWithFruit(String fruit) {
        return storage.get(fruit);
    }

    public boolean isFruitInStorage(String fruit) {
        return storage.containsKey(fruit);
    }

    public void addNewFruitToRange(String fruit, Integer quantity, LocalDate expirationDate) {
        storage.put(fruit, new TreeMap<>());
        storage.get(fruit).put(expirationDate, quantity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String fruit : storage.keySet()) {
            for (LocalDate expirationDate : storage.get(fruit).keySet()) {
                builder.append(fruit)
                        .append(",")
                        .append(storage.get(fruit).get(expirationDate))
                        .append(",")
                        .append(expirationDate)
                        .append("\n");
            }
        }
        return builder.toString();
    }
}
