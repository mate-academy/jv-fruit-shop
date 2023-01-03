package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TransactionsListService {
    List<FruitTransaction> getTransactionsList(String lines, Map<String, Integer> fruitMap);
}
