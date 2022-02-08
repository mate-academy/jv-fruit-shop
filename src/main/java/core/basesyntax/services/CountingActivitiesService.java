package core.basesyntax.services;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public interface CountingActivitiesService {
    Map<Fruit, Integer> countingActivities(List<Operation> operations,
                                           FruitStrategy fruitStrategy);
}
