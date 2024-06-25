package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactions);

    Map<String, Integer> getRepository();
}
