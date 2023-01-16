package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TransactionsProcessor {
    Map<String, Integer> process(List<FruitTransaction> fruitRecords);
}
