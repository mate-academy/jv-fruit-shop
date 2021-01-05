package core.dao;

import core.db.Storage;
import java.util.Optional;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(String fruit, int amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public int get(String fruit) {
        Optional<Integer> optionalInteger = Optional.ofNullable(Storage.fruits.get(fruit));
        return optionalInteger.orElse(0);
    }
}
