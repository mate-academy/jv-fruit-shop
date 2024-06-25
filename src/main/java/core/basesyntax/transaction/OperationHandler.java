package core.basesyntax.transaction;

import java.util.Map;

public interface OperationHandler {
    void execute(Map.Entry<String, Integer> entry, int value);
}
