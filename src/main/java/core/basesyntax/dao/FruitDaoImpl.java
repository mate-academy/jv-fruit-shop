package core.basesyntax.dao;

import core.basesyntax.bd.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, int amount) {
        Storage.fruitStorage.put(fruit, amount);
    }

    @Override
    public boolean contains(Fruit fruit) {
        return Storage.fruitStorage.containsKey(fruit);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruitStorage;
    }
}
