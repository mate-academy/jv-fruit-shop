package core.basesyntax.services;

import core.basesyntax.db.FruitDataBaseImpl;
import core.basesyntax.model.Fruit;
import java.util.Map;

public interface OperationsService {
    Map<Fruit, Integer> countingActivities(FruitDataBaseImpl fruitDataBase);
}
