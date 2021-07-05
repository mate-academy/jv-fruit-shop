package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(Fruit fruit, int fruitQuantity) {
        Storage.fruitStorage.put(fruit, fruitQuantity);
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getSet() {
        return Storage.fruitStorage.entrySet();
    }
}
