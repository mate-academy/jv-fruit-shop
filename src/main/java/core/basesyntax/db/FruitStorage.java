package core.basesyntax.db;

import core.basesyntax.models.Fruit;
import java.util.Map;

public record FruitStorage(Map<Fruit, Integer> storage) {
}
