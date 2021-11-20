package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.FruitListStrategy;

public abstract class Operation implements OperationService {
    protected final StorageDaoImpl storageDao = new StorageDaoImpl();
    protected final FruitListStrategy fruitList = new FruitListStrategy();
}
