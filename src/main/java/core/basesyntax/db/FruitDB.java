package core.basesyntax.db;

import java.util.Map;
import java.util.Set;

public interface FruitDB {
    int getQuantity(String fruit);

    void setQuantity(String fruit, int quantity);

    Set<Map.Entry<String, Integer>> getEntrySet();
}
