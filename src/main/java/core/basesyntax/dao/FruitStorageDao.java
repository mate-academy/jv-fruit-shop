package core.basesyntax.dao;

import java.util.Set;

public interface FruitStorageDao {
    void add(String fruit, int quantity);

    int getQuantity(String fruit);

    Set<String> getFruitSet();
}
