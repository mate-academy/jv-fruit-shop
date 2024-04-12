package core.basesyntax.db;

import java.util.Map;
import java.util.stream.Collectors;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruitName, int value) {
        Storage.fruits.put(fruitName, value);
    }

    @Override
    public Map<String, Integer> get(String fruitName) {
        return Storage.fruits.entrySet()
                .stream()
                .filter(name -> name.getKey().equals(fruitName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public int getQuantity(String fruitName) {
        return get(fruitName).values().stream().findFirst().orElse(0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }

    @Override
    public void update(String fruitName, int value) {
        Storage.fruits.remove(fruitName);
        add(fruitName, value);
    }
}
