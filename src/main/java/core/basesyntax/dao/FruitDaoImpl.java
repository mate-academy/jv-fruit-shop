package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.InvalidQuantityException;
import java.util.NoSuchElementException;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, int quantity) {
        checkQuantity(quantity);
        Storage.fruits.put(fruitName, quantity);
    }

    @Override
    public int get(String fruitName) {
        return Storage.fruits.get(fruitName);
    }

    @Override
    public void update(String fruitName, int quantity) {
        checkQuantity(quantity);
        if (containsFruit(fruitName)) {
            Storage.fruits.put(fruitName, quantity);
        } else {
            throw new NoSuchElementException("Can't find " + fruitName + " in Storage");
        }
    }

    @Override
    public void plus(String fruitName, int quantity) {
        Storage.fruits.merge(fruitName, quantity, Integer::sum);
    }

    @Override
    public boolean containsFruit(String fruitName) {
        return Storage.fruits.containsKey(fruitName);
    }

    private static void checkQuantity(int quantity) {
        if (quantity < 0) {
            throw new InvalidQuantityException("Quantity can't be less 0");
        }
    }
}
