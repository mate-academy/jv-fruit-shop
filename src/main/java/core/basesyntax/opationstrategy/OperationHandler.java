package core.basesyntax.opationstrategy;

import java.util.Map;

public interface OperationHandler {
    void handle(String fruit, int quantity, Map<String, Integer> storage);
}
