package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void update(String fruit, String quantity);

    Map<String, String> getAll();

    String getQuantity(String key);
}
