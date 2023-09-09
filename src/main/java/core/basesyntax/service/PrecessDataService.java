package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface PrecessDataService {
    void writeToStorage(List<FruitTransaction> fruitTransactionList);
}
