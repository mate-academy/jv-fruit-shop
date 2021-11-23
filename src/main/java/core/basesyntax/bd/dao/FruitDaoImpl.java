package core.basesyntax.bd.dao;

import core.basesyntax.bd.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(Fruit fruit, int amount) {
        FruitStorage.fruitStorage.put(fruit, amount);
    }

    @Override
    public Fruit getKey(Fruit fruit) {
        return FruitStorage.fruitStorage.keySet().stream()
                .filter(el -> el.getName().contains(fruit.getName()))
                .findFirst().orElse(null);
    }

    @Override
    public Integer getValue(Fruit fruit) {
        return FruitStorage.fruitStorage.containsKey(fruit)
                ? FruitStorage.fruitStorage.entrySet().stream()
                    .filter(el -> el.getKey().getName().contains(fruit.getName()))
                        .map(Map.Entry::getValue)
                        .findFirst().get() : null;
    }
}
