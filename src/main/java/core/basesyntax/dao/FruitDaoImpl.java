package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName) {
        Storage.fruitDB.put(fruitName, 0);
    }

    @Override
    public Integer get(String fruitName) {
        return Storage.fruitDB.getOrDefault(fruitName, 0);
    }

    @Override
    public void update(String fruitName, int quantity) {
        Storage.fruitDB.put(fruitName, quantity);
    }

}
