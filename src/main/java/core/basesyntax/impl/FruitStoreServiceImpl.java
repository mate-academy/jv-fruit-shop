package core.basesyntax.impl;

import core.basesyntax.activities.ActivitiesHandler;
import core.basesyntax.activities.ActivityType;
import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.startegy.ActivitiesStrategy;
import java.util.List;

public class FruitStoreServiceImpl implements FruitStoreService {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private FruitsDao fruitsDao;
    private ActivitiesStrategy activitiesStrategy;

    public FruitStoreServiceImpl(FruitsDao fruitsDao, ActivitiesStrategy activitiesStrategy) {
        this.fruitsDao = fruitsDao;
        this.activitiesStrategy = activitiesStrategy;
    }

    public List<Fruit> changeBalanceFruit(List<String> text) {
        for (int i = 1; i < text.size(); i++) {
            String[] arrayStringLine = text.get(i).split(",");
            String abbreviationActivityType = arrayStringLine[INDEX_OF_TYPE];
            String fruitName = arrayStringLine[INDEX_OF_FRUIT_NAME];
            int quantity = Integer.parseInt(arrayStringLine[INDEX_OF_QUANTITY]);
            ActivitiesHandler activitiesService = activitiesStrategy.get(ActivityType
                    .getActivityType(abbreviationActivityType));
            activitiesService.doActivity(fruitName, quantity, fruitsDao);
        }
        return fruitsDao.getAll();
    }
}
