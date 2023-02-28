package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.exeption.FruitShopExeption;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, Integer amount) {
        if (fruit == null || amount == null || amount <= 0) {
            throw new FruitShopExeption("Incorrect input data for adding to storage");
        }
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) + amount);
            return;
        }
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public void remove(String fruit, Integer amount) {
        if (fruit == null || amount == null) {
            throw new FruitShopExeption("Incorrect input data for removing from storage");
        }
        if (!Storage.fruits.containsKey(fruit) || Storage.fruits.get(fruit) < amount) {
            throw new FruitShopExeption("You want take away " + amount + " "
                    + fruit + ", but in storage only " + Storage.fruits.get(fruit));
        }
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) - amount);
    }
}
