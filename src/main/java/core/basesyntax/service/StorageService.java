package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface StorageService {
    Map<String, Integer> createReport(List<String> data);
}
