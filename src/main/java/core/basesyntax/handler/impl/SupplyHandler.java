package core.basesyntax.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.models.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    private StorageDao dao;

    public SupplyHandler(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void handle(FruitTransaction transition) {
        dao.addToStorage(transition.getFruit(),
                dao.getFromStorage(transition.getFruit()) + transition.getAmount());
    }
}
