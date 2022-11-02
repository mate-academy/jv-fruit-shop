package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(String fruitName, int quantity) {
        Storage.fruitStorage.put(fruitName, quantity);
    }

    @Override
    public void supply(String fruitName, int quantity) {
        Storage.fruitStorage.replace(fruitName, getAll().get(fruitName) + quantity);
    }

    @Override
    public void purchase(String fruitName, int quantity) {
        Storage.fruitStorage.replace(fruitName, getAll().get(fruitName) - quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitStorage;
    }

}
