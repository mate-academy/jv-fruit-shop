package core.basesyntax.service;

import java.util.List;

public interface StorageService {
    void updateStorage(List<String[]> inputData);

    List<String> getStorageStatistic();
}
