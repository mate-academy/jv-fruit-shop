package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactionList);

    Map<String, Integer> getStorage();
}
