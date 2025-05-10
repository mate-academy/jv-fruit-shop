package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ShopService {
    void process(List<FruitTransaction> transactions);

    void addFruits(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getFruits();
}
