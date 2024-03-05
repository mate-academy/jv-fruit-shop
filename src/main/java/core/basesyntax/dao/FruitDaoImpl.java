package java.core.basesyntax.dao;

import java.core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(String fruitName, int quantity) {
        FruitStorage.getFruits().put(fruitName, quantity);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return FruitStorage.getFruits();
    }

    @Override
    public int getQuantityByFruitName(String fruitName) {
        return FruitStorage.getFruits().get(fruitName);
    }
}
