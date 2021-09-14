package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface StorageInfoUpdateService {
    void updateStorageInfo(List<FruitRecord> recordList);
}
