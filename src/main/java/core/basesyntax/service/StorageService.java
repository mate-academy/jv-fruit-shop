package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface StorageService {
    void updateStorage(List<FruitRecord> recordList);
}
