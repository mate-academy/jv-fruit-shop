package core.basesyntax.dao.impl;

import core.basesyntax.dao.SaveAllRecords;
import core.basesyntax.db.Storage;
import java.util.Map;

public class SaveAllRecordsImpl implements SaveAllRecords {
    @Override
    public void save(Map<String, Integer> items) {
        Storage.records.clear();
        Storage.records.putAll(items);
    }
}
