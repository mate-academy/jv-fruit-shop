package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, Integer amount) {
        FruitDB.FRUIT_DB.put(fruit, amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return FruitDB.FRUIT_DB.getOrDefault(fruit, 0);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitDB.FRUIT_DB;
    }
}
