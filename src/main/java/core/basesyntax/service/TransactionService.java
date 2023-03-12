package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionService {
    void applyTransactions(List<FruitTransaction> transactions);
}
