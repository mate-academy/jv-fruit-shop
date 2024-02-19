package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionProcessor {
    void processTransaction(List<FruitTransaction> transactions);
}
