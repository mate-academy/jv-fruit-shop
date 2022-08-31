package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void set(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public void add(String fruit, int quantity) {
        Storage.fruits.replace(fruit, get(fruit) + quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        if (quantity > Storage.fruits.get(fruit)) {
            throw new RuntimeException("Can't sell more " + fruit + " then we have");
        }
        Storage.fruits.replace(fruit, get(fruit) - quantity);
    }

    @Override
    public int get(String fruit) {
        checkKeyPresence(fruit);
        return Storage.fruits.get(fruit);
    }

    @Override
    public String[] getFruitsNames() {
        return Storage.fruits.keySet().toArray(new String[0]);
    }

    private void checkKeyPresence(String fruit) {
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("We don't have such fruit: " + fruit);
        }
    }
}

