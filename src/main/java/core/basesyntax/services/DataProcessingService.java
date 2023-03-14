package core.basesyntax.services;

import java.util.List;
import java.util.Map;

public interface DataProcessingService {
    Map<String, Integer> processData(List<String[]> parcedData);
}
