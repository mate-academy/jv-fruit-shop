package core.basesyntax.db;

import java.util.Map;

public interface FruitStorage {
    int getQuantity(String fruit);

    void setQuantity(String fruit, int quantity);

    Map<String, Integer> getAll();
}
