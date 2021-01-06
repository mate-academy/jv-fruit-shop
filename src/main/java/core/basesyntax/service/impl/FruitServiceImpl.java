package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;

public class FruitServiceImpl extends StoreServiceImpl<Fruit> implements FruitService {

    public FruitServiceImpl(FruitDao fruitsDao, OperationStrategy operationStrategy) {
        super(fruitsDao, operationStrategy);
    }
}
