package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void clear() {
        FruitStorage.storage.clear();
    }

    @Override
    public void add(String fruit, Integer quantity) {
        FruitStorage.storage.put(fruit, quantity);
    }

    @Override
    public Integer getQuantity(String fruit) {
        Integer quantity = FruitStorage.storage.get(fruit);
        return quantity == null ? 0 : quantity;
    }

    @Override
    public Map<String, Integer> getData() {
        return FruitStorage.storage;
    }
}

