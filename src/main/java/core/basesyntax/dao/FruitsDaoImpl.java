package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(String fruit, int amount) {
        if (Storage.fruits.containsKey(fruit)) {
            Integer oldAmount = Storage.fruits.get(fruit);
            Storage.fruits.put(fruit, oldAmount + amount);
        } else {
            Storage.fruits.put(fruit, amount);
        }
    }

    @Override
    public void subtract(String fruit, int amount) {
        Integer oldAmount = Storage.fruits.get(fruit);
        Storage.fruits.put(fruit, oldAmount - amount);
    }

    @Override
    public Map<String, Integer> checkStorage() {
        return Storage.fruits;
    }
}
