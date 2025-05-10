package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public interface OperationHandler {
    void apply(FruitTransaction transaction, Map<String, Integer> storage);
}
