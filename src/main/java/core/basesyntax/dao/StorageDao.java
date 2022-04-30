package core.basesyntax.dao;

import java.util.List;

public interface StorageDao {
    void add(String fruit, int amount);

    int getAmount(String fruit);

    boolean isPresent(String fruit);

    List<String> getAll();
}
