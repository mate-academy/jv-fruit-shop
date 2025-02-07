package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void run(FruitTransaction fruitTransaction, Map<String, Integer> fruitRepository);
}
