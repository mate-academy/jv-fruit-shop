package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Integer getQuantity(Fruit fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public Integer add(String fruitName, Integer quantity) {
        return Storage.fruits.put(new Fruit(fruitName), quantity);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getEntrySet() {
        return Storage.fruits.entrySet();
    }
}
