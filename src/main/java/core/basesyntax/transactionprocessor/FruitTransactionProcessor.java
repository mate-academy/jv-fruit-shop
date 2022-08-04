package core.basesyntax.transactionprocessor;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionProcessor {
    void process(List<FruitTransaction> transactions);
}
