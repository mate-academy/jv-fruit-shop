package core.basesyntax.bd.dao;

import core.basesyntax.bd.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(Fruit fruit, int amount) {
        FruitStorage.FRUIT_STORAGE.put(fruit, amount);
    }

    @Override
    public Fruit get(Fruit fruit) {
        return FruitStorage.FRUIT_STORAGE.keySet().stream()
                .filter(el -> el.getName().equals(fruit.getName()))
                .findFirst().orElse(null);
    }

    @Override
    public Integer getValue(Fruit fruit) {
        return FruitStorage.FRUIT_STORAGE.entrySet().stream()
                .filter(el -> el.getKey().getName().equals(fruit.getName()))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);
    }
}
