package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandlerService {
    void addData(Fruit fruit, int quantity);
}
