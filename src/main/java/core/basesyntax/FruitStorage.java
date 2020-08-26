package core.basesyntax;

import core.basesyntax.exception.NotEnoughFruitException;
import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FruitStorage {
    private final Map<Fruit, Integer> storage = new HashMap<>();

    public void add(Fruit fruit, int quantity) {
        storage.merge(fruit, quantity, Integer::sum);
    }

    public void remove(String fruitName, LocalDate minExpirationDate, int quantity) {
        Map<Fruit, Integer> appropriateFruits
                = getAppropriateFruits(fruitName, minExpirationDate, quantity);
        for (Map.Entry<Fruit, Integer> entry : appropriateFruits.entrySet()) {
            if (entry.getValue() > quantity) {
                storage.put(entry.getKey(), entry.getValue() - quantity);
                return;
            }
            quantity -= entry.getValue();
            storage.remove(entry.getKey());
        }
    }

    public Map<String, Integer> getStockBalance() {
        return storage.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        Map.Entry::getValue,
                        Integer::sum
                ));
    }

    private Map<Fruit, Integer> getAppropriateFruits(
            String fruitName, LocalDate minExpirationDate, int quantity) {
        Map<Fruit, Integer> appropriateFruits =
                new TreeMap<>(Comparator.comparing(Fruit::getExpirationDate)
                        .thenComparing(Fruit::getName));
        appropriateFruits.putAll(storage);
        appropriateFruits.entrySet()
                .removeIf(entry ->
                        !entry.getKey().getName().equals(fruitName)
                        || entry.getKey().getExpirationDate().isBefore(minExpirationDate));
        int appropriateFruitsInStorage = appropriateFruits.values()
                .stream()
                .reduce(0, Integer::sum);
        if (appropriateFruitsInStorage < quantity) {
            String message = String.format("Asked to buy %d %s, but have %d",
                    quantity, fruitName, appropriateFruitsInStorage);
            throw new NotEnoughFruitException(message);
        }
        return appropriateFruits;
    }
}
