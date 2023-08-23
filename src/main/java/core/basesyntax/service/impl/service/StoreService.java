package core.basesyntax.service.impl.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StoreService {
    void putToMap(List<FruitTransaction> fruitTransactionList);
}
