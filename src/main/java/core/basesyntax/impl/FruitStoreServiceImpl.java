package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.startegy.ActivitiesService;
import core.basesyntax.startegy.ActivityType;
import java.util.List;
import java.util.Map;

public class FruitStoreServiceImpl implements FruitStoreService {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    public List<Fruit> changeBalanceFruit(List<String> text, Map<ActivityType,ActivitiesService>
            typeActivityMap, StorageDao storageDao) {
        for (int i = 1; i < text.size(); i++) {
            String[] arrayStringLine = text.get(i).split(",");
            String abbreviationActivityType = arrayStringLine[INDEX_OF_TYPE];
            String fruitName = arrayStringLine[INDEX_OF_FRUIT_NAME];
            int quantity = Integer.parseInt(arrayStringLine[INDEX_OF_QUANTITY]);
            ActivitiesService activitiesService = typeActivityMap.get(ActivityType
                    .getActivityType(abbreviationActivityType));
            activitiesService.doActivity(fruitName, quantity, storageDao);
        }
        return storageDao.getAll();
    }
}
