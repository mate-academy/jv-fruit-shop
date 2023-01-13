package core.basesyntax.strategy.operationhandler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    FruitDao fruitDao = new FruitDaoImpl();

    void handle(FruitTransaction fruitTransaction);
}
