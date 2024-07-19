package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.domain.Fruit;
import core.basesyntax.service.strategy.OperationStrategy;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private static final String APPLE_NAME = "apple";
    private static final String BANANA_NAME = "banana";
    private final FruitDao fruitDao;

    public ShopServiceImpl(OperationStrategy operationStrategy, FruitDao fruitDao) {
        this.operationStrategy = operationStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(List<Fruit> fruits) {
        int appleQuantity = 0;
        int bananaQuantity = 0;
        for (Fruit currentFruit : fruits) {
            Fruit.Operation currentOperation = currentFruit.getOperation();
            int currentQuantity = currentFruit.getQuantity();
            if (currentFruit.getName().equals(APPLE_NAME)) {
                appleQuantity = operationStrategy.get(currentOperation)
                        .getQuantity(appleQuantity, currentQuantity);
            } else if (currentFruit.getName().equals(BANANA_NAME)) {
                bananaQuantity = operationStrategy.get(currentOperation)
                        .getQuantity(bananaQuantity, currentQuantity);
            }
        }
        fruitDao.add(new Fruit(APPLE_NAME, appleQuantity));
        fruitDao.add(new Fruit(BANANA_NAME, bananaQuantity));
    }
}
