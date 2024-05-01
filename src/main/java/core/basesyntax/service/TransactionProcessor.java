package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<FruitTransaction> fruitTransactions);
}
