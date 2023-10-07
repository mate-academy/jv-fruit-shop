package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TransactionService {
    Map<String, Integer> handleTransactions(List<FruitTransaction> transactions);
}
