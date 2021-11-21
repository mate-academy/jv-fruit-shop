package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ActivityService;
import core.basesyntax.strategy.ActivityStrategy;

public class StorageServiceImpl implements StorageService {

    private ActivityStrategy activityStrategy;
    private FruitService fruitService;
    private FruitDao fruitDao;

    public StorageServiceImpl(ActivityStrategy activityStrategy, FruitService fruitService,
            FruitDao fruitDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
        this.fruitService = fruitService;
    }

    @Override
    public void releaseActivity(String strActivity) {
        String[] arrActivity = strActivity.split(",");
        Fruit fruit = fruitDao.get(arrActivity[1]);
        if (fruit == null) {
            fruit = fruitService.createNewFruit(arrActivity[1]);
        }
        ActivityService activityService = activityStrategy.getActivityService(arrActivity[0]);
        activityService.releaseActivity(fruit, Integer.parseInt(arrActivity[2]));
        fruitDao.update(fruit);
    }

}
