package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(String nameFruit, int quantity) {
        Storage.fruitStorage.put(nameFruit, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitStorage;
    }
}
