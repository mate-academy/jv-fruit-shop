package core.basesyntax.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handler.Handler;
import core.basesyntax.models.FruitTransition;

public class Purchase implements Handler {
    private StorageDao dao;

    public Purchase(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void doOperation(FruitTransition transition) {
        if (dao.getFromStorage(transition.getFruit()) >= transition.getAmount()) {
            dao.addToStorage(transition.getFruit(),
                    dao.getFromStorage(transition.getFruit()) - transition.getAmount());
        } else {
            throw new RuntimeException("You want buy too much fruit");
        }
    }
}
