package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportGeneratorService {
    List<String> generate(Map<String, Integer> fruitsAtStorageMap);
}
