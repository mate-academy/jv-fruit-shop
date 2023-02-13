package core.basesyntax.service;

import core.basesyntax.service.activities.StorageService;
import java.util.List;
import java.util.Map;

public interface ActivitiesService {
    void doingOperations(List<String> fromFile, Map<String, StorageService> storageMap);
}
