package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface BalanceHandler {
    Map<String, Integer> getBalanceComputedMap(List<FruitTransaction> fruitTransactions);
}
