package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addFruit(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public boolean containsFruit(String fruit) {
        return Storage.fruitStorage.containsKey(fruit);
    }

    @Override
    public void mergeQuantity(String fruit, int quantity) {
        Storage.fruitStorage.merge(fruit, quantity, Integer::sum);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.fruitStorage;
    }
}
