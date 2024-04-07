package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.NoSuchElementException;

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
        if (isExist(fruitName) && isValidQuantity(quantity)) {
            Storage.fruitStorage.put(fruitName, quantity);
        } else {
            throw new NoSuchElementException("There is no " + fruitName + " in storage");
        }
    }

    private boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    private boolean isExist(String fruitName) {
        return Storage.fruitStorage.containsKey(fruitName);
    }
}
