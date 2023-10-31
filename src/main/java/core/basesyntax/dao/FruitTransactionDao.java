package core.basesyntax.dao;

import java.util.Map;

public interface FruitTransactionDao {
    void add(String fruit, int quantity);

    void replace(String fruit, int quantity);

    Map<String, Integer> getALl();

    int get(String fruit);
}
