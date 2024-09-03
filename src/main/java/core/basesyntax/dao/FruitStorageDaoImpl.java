package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public Map<String, Integer> getAllFruits() {
        return FruitStorage.fruitStorage;
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return FruitStorage.fruitStorage.get(fruit);
    }
}
