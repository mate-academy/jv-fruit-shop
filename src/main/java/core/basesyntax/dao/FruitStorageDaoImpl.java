package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public void add(String fruit, int quantity) {
        FruitStorage.fruitToStorageQuantityMap.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return FruitStorage.fruitToStorageQuantityMap.get(fruit);
    }

    @Override
    public Map<String,Integer> getAll() {
        return FruitStorage.fruitToStorageQuantityMap;
    }
}
