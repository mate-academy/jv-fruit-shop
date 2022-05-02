package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitBuilder {
    List<Fruit> fruitBuilder(List<String> stringsFromFile);
}
