package core.basesyntax.operationhandler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public abstract class OperationHandler {
    protected static final FruitDao fruitDao = new FruitDaoImpl();

    public abstract void handle(FruitTransaction fruitTransaction);
}
