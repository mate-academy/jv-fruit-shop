package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(Fruit fruit, Integer integer) {
        Storage.storage.put(fruit, integer);
    }

    @Override
    public Integer getInteger(Fruit fruit) {
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            if (entry.getKey().getName().equals(fruit.getName())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
