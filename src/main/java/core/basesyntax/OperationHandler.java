package core.basesyntax;

import java.util.Map;

public interface OperationHandler {
    void handle(Map<String, Integer> report, String fruit, int quantity);
}
