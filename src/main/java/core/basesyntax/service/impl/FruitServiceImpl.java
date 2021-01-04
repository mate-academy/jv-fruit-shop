package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.objects.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;

public class FruitServiceImpl extends StoreServiceImpl<Fruit> implements FruitService {

    public FruitServiceImpl(FruitsDao fruitsDao, OperationStrategy operationStrategy) {
        super(fruitsDao, operationStrategy);
    }
}
