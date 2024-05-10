package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void updateQuantity(String fruitName, Integer quantity) {
        getFruitMap().put(fruitName, quantity);
    }

    @Override
    public Map<String, Integer> getFruitMap() {
        return Storage.FRUITS;
    }
}
