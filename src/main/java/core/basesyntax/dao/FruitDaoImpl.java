package core.basesyntax.dao;

import core.basesyntax.storage.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getFruits() {
        return FruitStorage.getFruits();
    }

    @Override
    public void addFruit(String fruitName, int quantity) {
        FruitStorage.getFruits().put(fruitName, quantity);
    }

    @Override
    public int getFruitQuantity(String fruitName) {
        return FruitStorage.getFruits().get(fruitName);
    }
}
