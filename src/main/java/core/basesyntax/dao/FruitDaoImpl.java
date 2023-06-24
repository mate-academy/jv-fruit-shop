package core.basesyntax.dao;

import core.basesyntax.fruit.Fruit;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    private final HashMap<String, Integer> shop = new HashMap<>();

    @Override
    public void put(String key, Integer value) {
        shop.put(key, value);
    }

    @Override
    public Integer getByName(String key) {
        return shop.get(key) == null ? 0 : shop.get(key);
    }

    @Override
    public List<Fruit> getAll() {
        return shop.entrySet()
                .stream()
                .map(entry -> new Fruit(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}


