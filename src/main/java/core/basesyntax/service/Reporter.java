package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface Reporter {
    List<String> generate(Map<String, Integer> finalState);
}
