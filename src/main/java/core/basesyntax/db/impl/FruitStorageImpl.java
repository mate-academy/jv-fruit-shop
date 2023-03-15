package core.basesyntax.db.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FruitStorageImpl implements FruitStorage {
    private final HashMap<String, Integer> storage = new HashMap<>();

    @Override
    public void put(Fruit fruit) {
        storage.put(fruit.getName(), fruit.getQuantity());
    }

    @Override
    public Fruit getByName(String name) {
        Integer quantity = storage.get(name);
        return new Fruit(name, quantity == null ? 0 : quantity);
    }

    @Override
    public List<Fruit> getAll() {
        return storage.entrySet()
                .stream()
                .map(entry -> new Fruit(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
