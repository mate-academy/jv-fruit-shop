package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(String fruit, Integer quantity) {
        int oldQuantity = Storage.fruits.getOrDefault(fruit, 0);
        Storage.fruits.put(fruit, oldQuantity + quantity);
    }

    @Override
    public void retrieve(String fruit, Integer quantity) {
        int oldQuantity = Storage.fruits.getOrDefault(fruit, 0);
        int newQuantity = oldQuantity - quantity;
        if (newQuantity < 0) {
            throw new IllegalStateException(fruit
                    + " is currently not in stock,"
                    + " Come back later!");
        }
        Storage.fruits.put(fruit, newQuantity);
    }
}
