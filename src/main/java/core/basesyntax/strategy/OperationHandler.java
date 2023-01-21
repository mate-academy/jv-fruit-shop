package core.basesyntax.strategy;

import java.util.Map;

public interface OperationHandler {

    void process(String fruit, int quantity, Map<String, Integer> storage);
}
