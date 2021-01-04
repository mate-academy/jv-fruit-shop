package core.basesyntax.parse;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitReport {
    String create(Map<Fruit, Integer> fruitIntegerMap);
}
