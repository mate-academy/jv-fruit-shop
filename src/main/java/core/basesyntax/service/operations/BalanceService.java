package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceService implements Operations{
    /**
     * save to the Storage remnants of fruits at the beginning of the working day
     */
    FruitDao fruitDao = new FruitDaoImpl();
    @Override
    public void realization(FruitTransaction fruit) {
        fruitDao.add(fruit);
    }
}
