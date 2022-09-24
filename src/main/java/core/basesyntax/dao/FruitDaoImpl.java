package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addFruit(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public boolean contains(String fruit) {
        return Storage.fruitStorage.containsKey(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitStorage;
    }
}
