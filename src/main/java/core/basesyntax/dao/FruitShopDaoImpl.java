package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(String nameFruit, int quantity) {
        Storage.fruitStorage.put(nameFruit, quantity);
    }
}
