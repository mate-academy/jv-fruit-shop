package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void put(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public void subtract(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > Storage.fruits.get(fruitTransaction.getFruit())) {
            throw new RuntimeException("We can't sell you more than "
                    + Storage.fruits.get(fruitTransaction.getFruit()));
        }
        Storage.fruits.put(fruitTransaction.getFruit(),
                Storage.fruits.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }

    @Override
    public void addition(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(),
                Storage.fruits.get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity());
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }
}
