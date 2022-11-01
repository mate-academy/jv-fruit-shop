package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public void updateQuantity(String fruit, Integer quantity) {
        Storage.fruitStorage.replace(fruit, quantity);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.fruitStorage;
    }
}
