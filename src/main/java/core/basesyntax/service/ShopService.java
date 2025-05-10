package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void processFruitTransactions(List<FruitTransaction> fruitTransactions,
                                  Map<String, Integer> inventory);
}
