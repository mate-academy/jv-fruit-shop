package core.basesyntax.handlers;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.fruittransaction.FruitTransaction;

public interface OperationHandler {
    void setDao(FruitsDao dao);

    void updateData(FruitTransaction transaction);
}
