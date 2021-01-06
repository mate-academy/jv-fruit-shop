package core.basesyntax.model.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;

public class FruitStoreImpl extends StoreImpl<Fruit> {

    public FruitStoreImpl(OperationStrategy operationStrategy) {
        super(operationStrategy);
        fruits = new ArrayList<>();
        fruitsDao = new FruitDaoImpl();
        storeService = new FruitServiceImpl(fruitsDao, operationStrategy);
    }
}
