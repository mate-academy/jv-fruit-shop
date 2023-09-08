package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void clearStorage() {
        Storage.getFruits().clear();
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.getFruits();
    }

    @Override
    public Integer getQuantity(String fruitName) {
        return Storage.getFruits().get(fruitName);
    }

    @Override
    public boolean containFruit(String fruitName) {
        return Storage.getFruits().containsKey(fruitName);
    }
}
