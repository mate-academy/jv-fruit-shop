package core.basesyntax.dao;

import java.util.Map;

public interface Dao {
    void add(String fruit, int quantity);

    Map<String, Integer> getAll();

    int getQuantity(String fruit);
}
