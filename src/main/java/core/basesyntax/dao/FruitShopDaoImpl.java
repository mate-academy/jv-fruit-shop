package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageForTests;
import core.basesyntax.model.FruitTransaction;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(String fruit, int amount) {
        Storage.storage.put(fruit, amount);
    }

    @Override
    public FruitTransaction get(String fruit) {
        for (FruitTransaction fruitForCheck : StorageForTests.storage) {
            if (fruitForCheck.getFruit().equals(fruit)) {
                return fruitForCheck;
            }
        }
        return null;
    }
}
