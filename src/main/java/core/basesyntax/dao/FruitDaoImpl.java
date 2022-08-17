package core.basesyntax.dao;

import core.basesyntax.db.FruitsStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void setQuantityForFruit(String fruit, int quantity) {
        FruitsStorage.getFruits().put(fruit, quantity);
    }

    @Override
    public int getQuantityForFruit(String fruit) {
        return FruitsStorage.getFruits().get(fruit);
    }

    @Override
    public Map<String, Integer> getStorageData() {
        return FruitsStorage.getFruits();
    }
}
