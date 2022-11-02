package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImplSupply implements FruitDao {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        Integer totalAmount = amount;
        if (Storage.storage.containsKey(fruit)) {
            totalAmount = Storage.storage.get(fruit) + amount;
        }
        Storage.storage.put(fruit, totalAmount);
        return fruit;
    }
}
