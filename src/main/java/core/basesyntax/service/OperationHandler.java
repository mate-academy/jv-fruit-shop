package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void process(FruitTransaction tx, Map<String, Integer> storage);
}
