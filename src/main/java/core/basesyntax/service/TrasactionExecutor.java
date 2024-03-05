package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TrasactionExecutor {
    void processTransactions(List<FruitTransaction> transactions);
}
