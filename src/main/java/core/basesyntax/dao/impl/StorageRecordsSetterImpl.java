package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageRecordsSetter;
import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageRecordsSetterImpl implements StorageRecordsSetter {
    @Override
    public void set(Map<String, Integer> items) {
        Storage.records.clear();
        Storage.records.putAll(items);
    }
}
