package core.basesyntax.service;

import core.basesyntax.db.StorageDao;
import core.basesyntax.strategy.FruitOperation;
import java.util.List;
import java.util.Map;

public interface FruitTransaction {
    void process(List<String> data, Map<String, FruitOperation> strategy, StorageDao storageDao);
}
