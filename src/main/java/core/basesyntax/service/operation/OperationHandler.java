package core.basesyntax.service.operation;

import core.basesyntax.dao.OperationDao;
import core.basesyntax.dao.impl.OperationDaoImpl;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    OperationDao operationDao = new OperationDaoImpl();
    void operationHandler(FruitTransaction fruitTransaction);
}
