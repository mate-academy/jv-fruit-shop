package core.basesyntax.model.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.objects.Fruit;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;

public class FruitStoreImpl extends StoreImpl<Fruit> {

    public FruitStoreImpl(OperationStrategy operationStrategy) {
        super(operationStrategy);
        plants = new ArrayList<>();
        plantsDao = new FruitsDaoImpl();
        storeService = new FruitServiceImpl((FruitsDao) plantsDao, operationStrategy);
    }
}
