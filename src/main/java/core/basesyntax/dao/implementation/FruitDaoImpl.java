package core.basesyntax.dao.implementation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final FruitStorage FRUIT_STORAGE = new FruitStorage();

    @Override
    public boolean contains(String fruitName) {
        return FRUIT_STORAGE.getMapOfFruits().containsKey(fruitName);
    }

    @Override
    public void add(String fruitName) {
        FRUIT_STORAGE.getMapOfFruits().put(fruitName, 0);
    }

    @Override
    public Integer get(String fruitName) {
        return FRUIT_STORAGE.getMapOfFruits().get(fruitName);
    }

    @Override
    public Map<String, Integer> getMap() {
        return FRUIT_STORAGE.getMapOfFruits();
    }

    @Override
    public void update(String fruitName, Integer newAmount) {
        FRUIT_STORAGE.getMapOfFruits().put(fruitName, newAmount);
    }
}
