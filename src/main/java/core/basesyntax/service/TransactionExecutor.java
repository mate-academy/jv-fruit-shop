package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TransactionExecutor {
    Map<String, Integer> executeAll(List<FruitTransaction> fruitTransactions);
}
