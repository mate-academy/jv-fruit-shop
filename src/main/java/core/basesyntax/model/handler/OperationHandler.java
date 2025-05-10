package core.basesyntax.model.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void handle(Map<String, Integer> storage, FruitTransaction transaction);
}
