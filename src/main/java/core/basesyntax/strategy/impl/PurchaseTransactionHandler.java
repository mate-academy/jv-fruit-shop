package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;

public class PurchaseTransactionHandler implements TransactionHandler {
    private final FruitStorageDao dao;

    public PurchaseTransactionHandler(FruitStorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        dao.update(transaction.getFruit(), transaction.getQuantity() * (-1));
    }
}
