package core.basesyntax;

import java.util.Map;

public interface OperationHandler {
    void handleTransaction(FruitTransaction transaction, Map<String, Integer> storage);
}
