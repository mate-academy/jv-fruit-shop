package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void apply(Map<String, Integer> storage, FruitTransaction transaction);
}
