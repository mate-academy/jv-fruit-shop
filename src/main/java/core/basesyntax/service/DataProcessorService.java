package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface DataProcessorService {
    Map<String, Integer> processData(List<String[]> lines);
}
