package core.basesyntax;

import java.util.Map;

public interface OperationHandler {
    void apply(Map<String, Integer> storage, FruitTransaction transaction);
}
