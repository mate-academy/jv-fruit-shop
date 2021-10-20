package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface FruitParser {
    Map<String, Integer> parse(List<String> input);
}
