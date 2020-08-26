package core.basesyntax.items;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private Map<String, Map<LocalDate, Integer>> fruitStorage = new TreeMap<>();

    public Map<LocalDate, Integer> getBoxWithFruit(String fruit) {
        return fruitStorage.get(fruit);
    }

    public boolean isFruitInStorage(String fruit) {
        return fruitStorage.containsKey(fruit);
    }

    public void addNewFruitToRange(String fruit, Integer quantity, LocalDate expirationDate) {
        fruitStorage.put(fruit, new TreeMap<>());
        fruitStorage.get(fruit).put(expirationDate, quantity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String fruit : fruitStorage.keySet()) {
            for (LocalDate expirationDate : fruitStorage.get(fruit).keySet()) {
                builder.append(fruit)
                        .append(",")
                        .append(fruitStorage.get(fruit).get(expirationDate))
                        .append(",")
                        .append(expirationDate)
                        .append("\n");
            }
        }
        return builder.toString();
    }
}
