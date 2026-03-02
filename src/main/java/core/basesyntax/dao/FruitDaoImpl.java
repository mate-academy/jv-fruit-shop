package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(String fruitName, int fruitAmount) {
        Storage.fruitStorage.put(fruitName, fruitAmount);
    }

    @Override
    public Integer getFruit(String fruitName) {
        return Storage.fruitStorage.get(fruitName);
    }
}
