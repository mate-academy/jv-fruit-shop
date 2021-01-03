package core.basesyntax.model;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.OperationStrategy;
import java.util.ArrayList;

public class FruitStoreImpl extends StoreImpl<Fruit> {

    public FruitStoreImpl(OperationStrategy operationStrategy) {
        super(operationStrategy);
        plants = new ArrayList<>();
        plantsDao = new FruitsDaoImpl();
        storeService = new FruitServiceImpl((FruitsDao) plantsDao, operationStrategy);
    }
}
