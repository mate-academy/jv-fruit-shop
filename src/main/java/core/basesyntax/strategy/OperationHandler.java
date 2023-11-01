package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void processWithData(FruitTransaction transaction, Map<String, Integer> data);
}
