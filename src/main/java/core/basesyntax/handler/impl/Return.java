package core.basesyntax.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handler.Handler;
import core.basesyntax.models.FruitTransition;

public class Return implements Handler {
    private StorageDao dao;

    public Return(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void doOperation(FruitTransition transition) {
        dao.addToStorage(transition.getFruit(),
                dao.getFromStorage(transition.getFruit()) + transition.getAmount());

    }
}

