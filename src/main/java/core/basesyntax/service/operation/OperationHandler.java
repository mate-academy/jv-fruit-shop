package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public interface OperationHandler {
    FruitDao fruitDao = new FruitDaoImpl();
    void operationHandler(String fruit, Integer quantity);
}
