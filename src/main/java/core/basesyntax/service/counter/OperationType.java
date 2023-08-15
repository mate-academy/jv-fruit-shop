package core.basesyntax.service.counter;

import core.basesyntax.service.transaction.FruitTransaction;
import java.util.Map;

public interface OperationType {

    void countFruits(Map<String, Integer> fruitTypesAndQuantity, FruitTransaction fruitTransaction);
}
