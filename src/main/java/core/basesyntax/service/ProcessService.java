package core.basesyntax.service;

import java.util.Map;

public interface ProcessService {
    StringBuilder getQuantity(String lines, Map<String, Integer> fruitMap);
}
