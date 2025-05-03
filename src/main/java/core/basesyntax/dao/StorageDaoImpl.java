package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Optional;

public class StorageDaoImpl implements StorageDao {
    private static final int DEFAULT_AMOUNT_VALUE = 0;

    @Override
    public void add(String fruit, Integer amount) {
        Storage.storage.put(fruit, amount);
    }

    @Override
    public int get(String fruit) {
        Optional<Integer> storageAmountWrapper = Optional.ofNullable(Storage.storage.get(fruit));
        return storageAmountWrapper.orElse(DEFAULT_AMOUNT_VALUE);
    }
}
