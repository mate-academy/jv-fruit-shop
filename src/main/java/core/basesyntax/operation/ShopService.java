package core.basesyntax.operation;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void addFruits(String fruit, int quantity);

    int getQuantity(String fruit);

    void process(List<FruitTransaction> transactions);

    Map<String, Integer> getFruits();
}
