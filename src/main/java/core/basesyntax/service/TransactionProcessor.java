package core.basesyntax.service;

import core.basesyntax.service.implementations.FruitTransaction;
import java.util.List;

public interface TransactionProcessor {
    void processData(List<FruitTransaction> fruitTransaction);
}
