package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void add(String fruit, Integer value) {
        Storage.fruits.put(fruit, value);
    }
}
