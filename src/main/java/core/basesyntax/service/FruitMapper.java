package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitMapper {
    List<Fruit> convert(List<String> data);
}
