package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseTransactionService {
    FruitTransaction parseTransaction(String line);

    List<FruitTransaction> parseStringTransactions(String transactions);
}
