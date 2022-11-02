package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void putFruit(FruitTransaction fruit) {
        Storage.fruits.put(fruit.getFruit(), fruit.getQuantity());
    }

    @Override
    public void putFruit(String fruitName, Integer quantity) {
        Storage.fruits.put(fruitName, quantity);
    }
}
