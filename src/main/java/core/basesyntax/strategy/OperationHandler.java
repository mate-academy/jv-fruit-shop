package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface OperationHandler {
    void handle(List<FruitTransaction> transactions, Map<String, Integer> inventory);
}
