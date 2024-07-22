package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.domain.FruitTransaction;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.getFruits().add(fruitTransaction);
    }
}
