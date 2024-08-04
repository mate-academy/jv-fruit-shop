package core.basesyntax;

import java.util.Map;

public interface OperationHandler {
    void handle(FruitTransaction transaction, Map<String, Integer> storage);

}
