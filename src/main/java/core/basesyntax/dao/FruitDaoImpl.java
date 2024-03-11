package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName) {
        Storage.fruitDB.put(fruitName, 0);
    }

    @Override
    public Integer get(String fruitName) {
        handleErrors(fruitName);
        return Storage.fruitDB.get(fruitName);
    }

    @Override
    public void update(String fruitName, int quantity) {
        handleErrors(fruitName);
        Storage.fruitDB.put(fruitName, quantity);
    }

    private void handleErrors(String fruitName) {
        if (Storage.fruitDB.get(fruitName) == null) {
            throw new RuntimeException(fruitName + " isn't exist in fruitDB");
        }
    }
}
