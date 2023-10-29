package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    Map<String, Integer> handleOperation(FruitTransaction transaction,
                                         Map<String, Integer> fruitQuantities);
}
