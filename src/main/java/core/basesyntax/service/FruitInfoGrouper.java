package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface FruitInfoGrouper {
    Map<String, Integer> groupFruitsInfo(List<Fruit> fruits);
}
