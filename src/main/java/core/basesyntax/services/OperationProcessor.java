package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationProcessor {
    void manageTransactions(List<FruitTransaction> transactions);
}
