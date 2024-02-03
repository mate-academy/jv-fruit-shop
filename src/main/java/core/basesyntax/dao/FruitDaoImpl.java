package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void putFruitToStorage(String fruitName, Integer fruitQuantity) {
        Storage.fruitStorage.put(fruitName, fruitQuantity);
    }

    @Override
    public Integer getFruit(String fruitName) {
        return Storage.fruitStorage.get(fruitName);
    }
}
