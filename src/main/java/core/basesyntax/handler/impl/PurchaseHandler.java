package core.basesyntax.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.models.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private StorageDao dao;

    public PurchaseHandler(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void handle(FruitTransaction transition) {
        if (dao.getFromStorage(transition.getFruit()) >= transition.getAmount()) {
            dao.addToStorage(transition.getFruit(),
                    dao.getFromStorage(transition.getFruit()) - transition.getAmount());
        } else {
            throw new RuntimeException("You want buy too much fruit");
        }
    }
}
