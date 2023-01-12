package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StorageUpdateService {
    void updateValue(List<FruitTransaction> fruitTransactions);
}
