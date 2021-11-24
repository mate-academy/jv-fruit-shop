package core.basesyntax.service;

import java.util.Map;

public interface StorageService {
    void releaseActivity(String strActivity);

    Map.Entry getEntry(String fruitName);
}
