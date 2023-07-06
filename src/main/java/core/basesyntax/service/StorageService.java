package core.basesyntax.service;

import core.basesyntax.service.activities.Handler;
import java.util.Map;

public interface StorageService {
    void putDataToStorage(Map<String, Handler> map);
}
