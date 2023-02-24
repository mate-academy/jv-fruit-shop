package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;

public class FruitReturnService implements FruitTransactionHandler {
    private final FruitTransactionDao transactionDao;

    public FruitReturnService() {
        transactionDao = new FruitTransactionDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit().getName();
        int prev = Storage.fruitMap.getOrDefault(fruitName, 0);
        int current = prev + transaction.getQuantity();
        transactionDao.putFruitIntoMap(fruitName, current);
    }
}
