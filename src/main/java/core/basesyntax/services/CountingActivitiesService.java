package core.basesyntax.services;

import core.basesyntax.model.Operation;
import core.basesyntax.services.handlers.FruitHandler;
import java.util.List;
import java.util.Map;

public interface CountingActivitiesService {
    Map<String, Integer> countingActivities(List<Operation> operations,
                                            Map<String, FruitHandler> fruitStrategy);
}
