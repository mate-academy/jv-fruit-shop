package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public void add(String fruitType, int quantityOfFruit) {
        Storage.storage.put(fruitType, quantityOfFruit);
    }

    @Override
    public int getQuantityOfFruit(String fruitType) {
        return Storage.storage.get(fruitType);
    }

    @Override
    public boolean containsFruit(String fruitType) {
        return Storage.storage.containsKey(fruitType);
    }

}
