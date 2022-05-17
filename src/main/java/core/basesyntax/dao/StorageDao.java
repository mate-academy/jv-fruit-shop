package core.basesyntax.dao;

import java.util.List;

public interface StorageDao {
    void add(String fruit, int quantity);

    int getQuantity(String fruit);

    boolean isPresent(String fruit);

    List<String> getAllFruits();
}
