package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public void plus(String fruit, int quantity) {
        containsKey(fruit);
        Storage.fruits.replace(fruit, getAmount(fruit) + quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        containsKey(fruit);
        if (quantity > Storage.fruits.get(fruit)) {
            throw new RuntimeException("Can't sell more " + fruit + " products then we have");
        }
        Storage.fruits.replace(fruit, getAmount(fruit) - quantity);
    }

    @Override
    public int getAmount(String fruit) {
        containsKey(fruit);
        return Storage.fruits.get(fruit);
    }

    @Override
    public String[] getFruitsNames() {
        return Storage.fruits.keySet().toArray(new String[0]);
    }

    private void containsKey(String fruit) {
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("We don't have such fruit: " + fruit);
        }
    }
}
