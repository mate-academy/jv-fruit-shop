package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.ActivityService;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.Map;

public class StorageServiceImpl implements StorageService {

    private ActivityStrategy activityStrategy;
    private FruitService fruitService;

    public StorageServiceImpl(ActivityStrategy activityStrategy,
                              FruitService fruitService) {
        this.activityStrategy = activityStrategy;
        this.fruitService = fruitService;
    }

    @Override
    public void releaseActivity(String strActivity) {
        String[] arrActivity = strActivity.split(",");
        ActivityService activityService = activityStrategy.getActivityService(arrActivity[0]);
        Map.Entry entryStore = getEntry(arrActivity[1]);
        Fruit fruit;
        Integer curCount = 0;
        if (entryStore == null) {
            fruit = fruitService.createNewFruit(arrActivity[1]);
        } else {
            fruit = (Fruit) entryStore.getKey();
            curCount = (Integer) entryStore.getValue();
        }
        Integer newCount = activityService.getNewCount(curCount, Integer.parseInt(arrActivity[2]));
        Storage.getStore().put(fruit, newCount);
    }

    public Map.Entry getEntry(String fruitName) {
        return Storage.getStore()
                .entrySet()
                .stream()
                .filter(kv -> kv.getKey().getName().equals(fruitName))
                .findFirst().orElse(null);
    }

}
