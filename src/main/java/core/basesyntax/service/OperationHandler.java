package core.basesyntax.service;

import java.util.Map;

public interface OperationHandler {
    void apply(String fruit, int quantity, Map<String, Integer> storage);
}
