package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageRecordsGetter;
import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageRecordsGetterImpl implements StorageRecordsGetter {
    @Override
    public Map<String,Integer> get() {
        return Storage.records;
    }
}
