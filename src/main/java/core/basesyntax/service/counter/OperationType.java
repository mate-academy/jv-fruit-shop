package core.basesyntax.service.counter;

import core.basesyntax.models.Fruit;
import java.util.Map;

public interface OperationType {
    int FRUIT_TYPE = 1;
    int FRUIT_QUANTITY = 2;
    void countFruits(Map<Fruit, Integer> dataToUpdateReport,
                     Map<String, Fruit> fruitTypes, String string);
}
