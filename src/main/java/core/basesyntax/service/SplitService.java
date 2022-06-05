package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface SplitService {
    FruitTransaction getTransactionFromRow(String line);
}
