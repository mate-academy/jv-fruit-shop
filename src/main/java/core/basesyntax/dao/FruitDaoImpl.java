package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Integer add(String fruitName, int amount) {
        return Storage.fruits.merge(fruitName, amount, Integer::sum);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getFruits() {
        return Storage.fruits.entrySet();
    }
}
