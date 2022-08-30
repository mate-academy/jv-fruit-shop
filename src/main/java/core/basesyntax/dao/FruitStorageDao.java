package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.Set;

public interface FruitStorageDao {
    void addTransaction(FruitTransaction transaction);

    Set<Map.Entry<String, Integer>> getData();
}
