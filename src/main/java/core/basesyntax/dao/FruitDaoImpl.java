package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addFruit(String fruit, Integer quantity) {
        Storage.getStock().put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getBalance() {
        return Storage.getStock();
    }
}
