package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void saveFruit(String fruit, int quantity) {
        FruitStorage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return FruitStorage.fruitStorage.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.fruitStorage;
    }
}
