package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivitiesService;
import core.basesyntax.startegy.ActivityType;
import java.util.List;
import java.util.Map;

public interface FruitStoreService {
    List<Fruit> changeBalanceFruit(List<String> text, Map<ActivityType,
            ActivitiesService> typeActivity, StorageDao storageDao);
}
