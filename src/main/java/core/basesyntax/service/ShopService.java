package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ShopService {
    Map<String, Integer> getFruitRepository();

    void process(List<FruitTransaction> fruitTransactions);
}
