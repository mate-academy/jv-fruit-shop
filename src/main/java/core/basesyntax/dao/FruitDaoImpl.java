package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public class FruitDaoImpl implements FruitDao{
    @Override
    public List<Fruit> get() {
        return null;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
