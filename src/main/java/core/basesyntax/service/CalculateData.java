package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface CalculateData {
    Map<String, Integer> calculateData(List<String[]> lines);
}
