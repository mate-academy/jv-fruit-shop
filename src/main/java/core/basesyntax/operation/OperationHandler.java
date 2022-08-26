package core.basesyntax.operation;

import java.util.Map;

public interface OperationHandler {
    void processingOperation(String fruit, int quantity, Map<String, Integer> values);
}
