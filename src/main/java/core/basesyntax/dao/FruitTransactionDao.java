package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitTransactionDao {
    void add(String fruit, int quantity);

    void update(String fruit, int quantity);

    int getQuantity(String fruit);

    Set<Map.Entry<String, Integer>> getEntries();
}
