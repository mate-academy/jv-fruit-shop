package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface Warehouse {
    boolean operationHandler(FruitTransaction fruitTransaction);

    Map<String, Integer> getRemains();

    List<FruitTransaction> getDayOperations();
}
