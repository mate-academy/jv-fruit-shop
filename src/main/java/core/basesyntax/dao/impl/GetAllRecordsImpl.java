package core.basesyntax.dao.impl;

import core.basesyntax.dao.GetAllRecords;
import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.stream.Collectors;

public class GetAllRecordsImpl implements GetAllRecords {
    @Override
    public Map<String,Integer> get() {
        return Storage.records
               .entrySet()
               .stream()
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
