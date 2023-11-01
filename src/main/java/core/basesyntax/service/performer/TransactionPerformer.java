package core.basesyntax.service.performer;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionPerformer {
    void performTransactions(List<FruitTransaction> transactions);
}
