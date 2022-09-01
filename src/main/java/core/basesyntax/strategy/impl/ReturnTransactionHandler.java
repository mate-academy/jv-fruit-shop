package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;

public class ReturnTransactionHandler implements TransactionHandler {
    private final FruitStorageDao dao;

    public ReturnTransactionHandler(FruitStorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        dao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
