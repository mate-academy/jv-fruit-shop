package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public int getQuantityByName(String fruit) {
        return FruitStorage.storageFruits.get(fruit);
    }

    @Override
    public void saveQuantity(String fruit, int quantity) {
        FruitStorage.storageFruits.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.storageFruits;
    }
}
