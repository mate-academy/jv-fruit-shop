package core.basesyntax.service;

import java.util.Map;

public interface OperationHandler {
    void process(FruitTransaction transaction, Map<String, Integer> storage);
}
