package core.basesyntax.service;

import core.basesyntax.model.Operation;

public abstract class OperationHandler {
    protected final ShopDao dao;

    public OperationHandler(ShopDao dao) {
        this.dao = dao;
    }

    public abstract void process(Operation operation);
}
