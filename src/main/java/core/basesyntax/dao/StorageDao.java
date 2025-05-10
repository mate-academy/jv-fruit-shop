package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface StorageDao {
    void add(FruitTransaction fruit);

    Integer getValue(String fruit);

    Map<String, Integer> getStorage();
}
