package core.basesyntax.service;

import java.util.List;

public interface FruitTransactionsService {
    List<FruitTransaction> getFruitTransactions(List<String> lines);
}
