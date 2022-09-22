package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public class FruitDaoImpl implements FruitDao{

    @Override
    public int getFruitAmount(FruitTransaction fruitTransaction) {
        return Storage.fruits.get(fruitTransaction.getFruit());
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }

    @Override
    public void changeAmount(FruitTransaction fruitTransaction, int newAmount) {
        Storage.fruits.replace(fruitTransaction.getFruit(),newAmount);
    }

}
