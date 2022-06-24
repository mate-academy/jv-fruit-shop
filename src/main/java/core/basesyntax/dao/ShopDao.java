package core.basesyntax.dao;

import java.util.Map;
import java.util.Optional;

public interface ShopDao {
    Integer get(String fruit);

    Map<String, Integer> getAll();

    void update(String fruit, int newAmount);
}
