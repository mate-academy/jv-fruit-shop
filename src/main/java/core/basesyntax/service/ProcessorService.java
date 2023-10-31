package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessorService {
    void processTransactions(List<FruitTransaction> transactions, FruitStorage storage);
}

