package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface ShopService {
    Map<String, Integer> process(Map<FruitTransaction.Operation,
            Map<String, Integer>> fruitTransactions);
}
