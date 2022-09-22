package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;

public class FruitDaoImpl implements FruitDao {

    @Override
    public int getFruitAmount(FruitTransaction fruitTransaction) {
        return Storage.getFruits().get(fruitTransaction.getFruit());
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.getFruits().put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    @Override
    public void changeAmount(FruitTransaction fruitTransaction, int newAmount) {
        Storage.getFruits().replace(fruitTransaction.getFruit(), newAmount);
    }

    @Override
    public HashMap<Fruit, Integer> getStorage() {
        return Storage.getFruits();
    }
}
