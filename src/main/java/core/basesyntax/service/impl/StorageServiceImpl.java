package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class StorageServiceImpl implements StorageService {

    @Override
    public Map<Fruit, Integer> getAllData() {
        return Storage.fruits;
    }
}
