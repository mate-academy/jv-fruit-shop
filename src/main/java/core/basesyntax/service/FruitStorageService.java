package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitStorageService {
    void manageTransactions(List<FruitTransaction> transactions);
}
