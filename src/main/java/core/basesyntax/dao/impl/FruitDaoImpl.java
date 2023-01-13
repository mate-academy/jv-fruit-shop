package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void updateQuantity(String fruit, int quantity) {
        FruitStorage.fruitStorage.merge(fruit, quantity, Integer::sum);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return FruitStorage.fruitStorage.get(fruit);
    }

    @Override
    public boolean containsFruit(String fruit) {
        return FruitStorage.fruitStorage.containsKey(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return FruitStorage.fruitStorage;
    }
}
