package core.basesyntax.fruitstorage;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.fruitmodel.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage implements FruitDao {
    private static Map<Fruit, Integer> fruitStorage = new HashMap<>();

    @Override
    public void save(Fruit fruit, Integer quantity) {
        fruitStorage.put(fruit, quantity);
    }

    @Override
    public Integer get(Fruit fruit) {
        return fruitStorage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return fruitStorage;
    }
}
