package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionsService {
    List<FruitTransaction> getTransactions(String data);
}
