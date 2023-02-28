package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface FruitShop {
    Map<String, Integer> report(List<List<String>> parsed);
}
