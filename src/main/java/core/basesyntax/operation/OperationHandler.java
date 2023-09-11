package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void handleTransaction(FruitTransaction transaction, Map<String, Integer> storage);
}
