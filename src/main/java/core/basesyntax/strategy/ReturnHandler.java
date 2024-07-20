package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ReturnHandler {
    Map<String, Integer> getReturnComputedMap(List<FruitTransaction> fruitTransactions);
}
