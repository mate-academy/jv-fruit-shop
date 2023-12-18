package core.basesyntax.service;

import java.util.Map;

public interface StatisticsStorageService {
    void store(Map<String, Integer> statistics);
}
