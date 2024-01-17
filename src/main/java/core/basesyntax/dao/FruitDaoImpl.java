package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.util.NoSuchElementException;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addFruit(String fruit, int quantity) {
        Storage.fruits.merge(fruit, quantity, Integer::sum);
    }

    @Override
    public void subtractFruit(String fruit, int quantity) {
        int currentQuantity = Storage.fruits.get(fruit);
        if (currentQuantity >= quantity) {
            int newQuantity = currentQuantity - quantity;
            Storage.fruits.put(fruit, newQuantity);
        } else {
            throw new RuntimeException("Not enough " + fruit);
        }
    }

    @Override
    public void setFruit(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
