package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public interface OperationHendler {
    void getOperation(FruitDao fruitDao, FruitTransaction fruitTransaction);
}
