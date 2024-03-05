package java.core.basesyntax.service;

import java.util.List;
import java.core.basesyntax.model.FruitTransaction;

public interface FruitService {
    void processTransactions(List<FruitTransaction> transactions);
}
