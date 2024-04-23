package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionService {
    boolean processTransactions(List<FruitTransaction> transactions);
}
