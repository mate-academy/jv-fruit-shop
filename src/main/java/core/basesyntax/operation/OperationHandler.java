package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void handle(Map<String, Integer> inventory, FruitTransaction fruitTransaction);

}
