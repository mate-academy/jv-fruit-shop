package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface PurchaseHandler {
    Map<String, Integer> getPurchaseComputedMap(List<FruitTransaction> fruitTransactions);
}
