package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ContentGenerator {
    String generateContent(Map<Fruit, Integer> map);
}
