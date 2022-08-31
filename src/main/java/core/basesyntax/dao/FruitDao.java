package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void set(String product, int quantity);

    void add(String product, int quantity);

    void subtract(String product, int quantity);

    int get(String product);

    Map<String, Integer> getAll();
}
