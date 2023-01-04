package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionsListService {
    List<FruitTransaction> getTransactionsList(String data);
}
