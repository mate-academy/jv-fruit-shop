package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, int quantity) {
        if (isValidQuantity(quantity)) {
            Storage.fruitStorage.put(fruitName, quantity);
        }
    }

    @Override
    public int get(String fruitName) {
        return Storage.fruitStorage.get(fruitName);
    }

    @Override
    public void update(String fruitName, int quantity) {
        if (isValidQuantity(quantity)) {
            Storage.fruitStorage.put(fruitName, quantity);
        }
    }

    private boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }
}
