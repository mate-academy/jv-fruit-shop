package core.basesyntax.operations;

import core.basesyntax.dao.FruitsDao;

public interface OperationHandler {
    void processLineData(String product, int quantity, FruitsDao fruitsDao);
}
