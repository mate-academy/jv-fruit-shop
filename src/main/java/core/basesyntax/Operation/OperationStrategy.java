package core.basesyntax.Operation;

import core.basesyntax.Model.FruitTransaction;

import java.util.Map;

public interface OperationStrategy {
    void processTransaction(Map<String, Integer> storage, FruitTransaction transaction);
}
