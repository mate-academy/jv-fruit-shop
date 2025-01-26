package core.basesyntax.Operation;

import core.basesyntax.Model.FruitTransaction;

import java.util.Map;

public interface OperationHandler {
    void handle(Map<String, Integer> storage, FruitTransaction transaction);
}
