package core.basesyntax.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.strategy.ManipulationService;
import core.basesyntax.strategy.Manipulations;
import java.util.List;
import java.util.Map;

public class FruitStoreServiceImpl implements FruitStoreService {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    public List<Fruit> changeBalance(List<String> text, Map<Manipulations, ManipulationService>
            typeActivityMap, FruitStorageDao storageDao) {
        for (int i = 1; i < text.size(); i++) {
            String[] arrayStringLine = text.get(i).split(",");
            String abbreviationActivityType = arrayStringLine[INDEX_OF_TYPE];
            String fruitName = arrayStringLine[INDEX_OF_FRUIT_NAME];
            int quantity = Integer.parseInt(arrayStringLine[INDEX_OF_QUANTITY]);
            ManipulationService activitiesService =
                    typeActivityMap.get(Manipulations.getManipulation(abbreviationActivityType));
            activitiesService.manipulate(fruitName, quantity, storageDao);
        }
        return storageDao.getAll();
    }
}
