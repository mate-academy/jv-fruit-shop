package core.basesyntax.db;

import java.util.Map;

public interface StorageDao {
    void add(String product, Integer value);

    void substractAmount(String product, Integer amountToDelete);

    void addAmount(String product, Integer amountToAdd);

    Map<String, Integer> getStock();
}
