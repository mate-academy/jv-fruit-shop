package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;

public class FruitServiceImpl extends StoreServiceImpl<Fruit> implements FruitService {

    public FruitServiceImpl(FruitsDao fruitsDao, OperationStrategy operationStrategy) {
        super(fruitsDao, operationStrategy);
    }
}
