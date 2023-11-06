package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionsGetter {
    List<FruitTransaction> getTransactions(String data);
}
