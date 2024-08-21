package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void transaction(FruitTransaction fruitTransaction, Map<String, Integer> fruits);
}
