package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorageImpl implements Storage {
    private Map<String, Fruit> storage = new HashMap<>();

    @Override
    public void put(Fruit fruit) {
        storage.put(fruit.getFruitName(), fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return storage.get(fruitName);
    }

    @Override
    public List<Fruit> getAll() {
        return storage.entrySet()
            .stream()
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
    }
}
