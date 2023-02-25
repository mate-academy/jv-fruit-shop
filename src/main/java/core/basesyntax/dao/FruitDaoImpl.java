package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, Integer amount) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) + amount);
            return;
        }
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public void takeAway(String fruit, Integer amount) {
        if (!Storage.fruits.containsKey(fruit) || Storage.fruits.get(fruit) < amount) {
            throw new RuntimeException("You want take away " + amount + " "
                    + fruit + ", but in storage only " + Storage.fruits.get(fruit));
        }
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) - amount);
    }
}
