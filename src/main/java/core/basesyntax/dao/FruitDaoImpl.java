package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitsDao {
    @Override
    public void add(String name, int amount) {
        Integer amountInStorage = Storage.fruits.get(name);
        if (amountInStorage != null) {
            Storage.fruits.put(name, amountInStorage + amount);
        } else {
            Storage.fruits.put(name, amount);
        }
    }

    @Override
    public void remove(String name, int amount) {
        Storage.fruits.put(name, Storage.fruits.get(name) - amount);
    }

    @Override
    public void set(String name, int amount) {
        Storage.fruits.put(name, amount);
    }
}
