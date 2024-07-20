package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface SupplyHandler {
    Map<String, Integer> getSupplyComputedMap(List<FruitTransaction> fruitTransactions);
}
