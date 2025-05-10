package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionProcessor;

public class BalanceCodeService implements TransactionProcessor {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void processTransaction(FruitTransaction transaction) {
        if (fruitDao.getAll().containsKey(transaction.getFruit())) {
            int oldQuantity = fruitDao.get(transaction.getFruit());
            fruitDao.add(transaction.getFruit(), transaction.getQuantity() + oldQuantity);
        } else {
            fruitDao.add(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
