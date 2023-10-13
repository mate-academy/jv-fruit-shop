package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String name, int amount) {
        int currentAmount = Storage.getFruits().getOrDefault(name, 0);
        Storage.getFruits().put(name, currentAmount + amount);
    }

    @Override
    public void remove(String name, int amount) {
        Storage.getFruits().put(name, Storage.getFruits().get(name) - amount);
    }

    @Override
    public void set(String name, int amount) {
        Storage.getFruits().put(name, amount);
    }
}
