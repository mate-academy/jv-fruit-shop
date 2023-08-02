package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivityWorkerService;
import core.basesyntax.service.strategy.ActivityHandler;
import core.basesyntax.service.strategy.ActivityStrategy;
import java.util.List;

public class ActivityWorkerServiceImpl implements ActivityWorkerService {
    private final ActivityStrategy activityStrategy;
    private final FruitDao fruitDao;

    public ActivityWorkerServiceImpl(ActivityStrategy activityStrategy, FruitDao fruitDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
    }

    public void modifyQuantity(List<Fruit> convertedData) {
        for (Fruit fruit : convertedData) {
            int fruitQuantity = fruitDao.getAll().getOrDefault(fruit.getFruit(),0);
            fruitDao.put(fruit.getFruit(),
                    fruitModify(fruit, fruitQuantity));
        }
    }

    private int fruitModify(Fruit toModify, int fruitQuantity) {
        ActivityHandler activityService = activityStrategy
                .getQuantityModifier(toModify.getOperation());
        return activityService.quantityModify(fruitQuantity, toModify.getQuantity());
    }
}
