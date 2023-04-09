package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface DailyBalanceCalculator {
    Map<String, Integer> calculateBalance(List<FruitTransaction> fruitTransactionFromDb);
}
