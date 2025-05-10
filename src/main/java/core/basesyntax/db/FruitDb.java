package core.basesyntax.db;

import java.util.Map;
import java.util.Set;

public interface FruitDb {
    int getQuantity(String fruit);

    void setQuantity(String fruit, int quantity);

    Set<Map.Entry<String, Integer>> getEntrySet();
}
