package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ProcessWithData {
    Map<String, Integer> processWithData(List<String[]> list);
}
