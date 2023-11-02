package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitQuantityDaoImpl implements FruitQuantityDao {
    @Override
    public void add(String fruit, int quantity) {
        FruitStorage.fruitQuantity.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.fruitQuantity;
    }

    @Override
    public int get(String fruit) {
        return FruitStorage.fruitQuantity.get(fruit);
    }
}
