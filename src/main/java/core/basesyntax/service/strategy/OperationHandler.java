package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;

public interface OperationHandler {

    void getOperation(FruitDao fruitDao, String fruit, int quantity);
}
