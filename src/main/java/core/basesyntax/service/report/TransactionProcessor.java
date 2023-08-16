package core.basesyntax.service.report;

import core.basesyntax.service.transaction.FruitTransaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<FruitTransaction> fruitTransactionList);
}
