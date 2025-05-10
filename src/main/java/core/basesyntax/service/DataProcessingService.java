package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface DataProcessingService {
    Map<String, Integer> getFruit(List<String> linesList);
}
