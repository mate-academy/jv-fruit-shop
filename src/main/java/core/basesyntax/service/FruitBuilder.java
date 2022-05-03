package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitBuilder {
    List<Fruit> buildFruit(List<String> sourceData);
}
