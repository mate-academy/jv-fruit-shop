package core.basesyntax.operation;

import java.util.Map;

public interface OperationHandler {
    void execute(Map.Entry<String, Integer> entry, int value);
}
