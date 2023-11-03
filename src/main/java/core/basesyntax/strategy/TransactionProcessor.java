package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<FruitTransaction> fruitTransactionsList);
}
