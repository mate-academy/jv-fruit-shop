package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void putFruitIntoMap(String fruitName, Integer count) {
        Storage.fruitMap.put(fruitName, count);
    }
}
