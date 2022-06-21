package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface ActionsDao {
    void add(String fruit, Integer amount);

    void update(String fruit, Integer amount);

    int getAmount(String fruit);

    boolean isPresentFruit(String fruit);

    Set<Map.Entry<String, Integer>> getAllFruits();
}
