package core.basesyntax.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.models.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private StorageDao dao;

    public BalanceHandler(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void handle(FruitTransaction transition) {
        dao.addToStorage(transition.getFruit(), transition.getAmount());
    }
}
