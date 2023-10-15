package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String name, int quantity) {
        int currentAmount = Storage.getFruits().getOrDefault(name, 0);
        Storage.getFruits().put(name, currentAmount + quantity);
    }

    @Override
    public void remove(String name, int quantity) {
        if (Storage.getFruits().get(name) < quantity) {
            throw new RuntimeException("Not enough " + name + " to purchase");
        }
        Storage.getFruits().put(name, Storage.getFruits().get(name) - quantity);
    }

    @Override
    public void set(String name, int quantity) {
        Storage.getFruits().put(name, quantity);
    }
}
