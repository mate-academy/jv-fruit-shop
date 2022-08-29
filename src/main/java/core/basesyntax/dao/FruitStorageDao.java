package core.basesyntax.dao;

import java.util.Map;
import core.basesyntax.model.FruitTransaction;

public interface FruitStorageDao {
    void addTransaction(FruitTransaction transaction);

    Map<String, Integer> getData();
}
