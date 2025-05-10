package core.basesyntax.dao;

import java.util.Map;

public interface FruitTransactionDao {
    void add(String fruit, int quantity);

    void update(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getStorage();
}
