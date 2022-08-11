package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;

public interface OperationHandler {
    void runOperation(FruitsDao fruitsDao, String fruitName, int quantity);
}
