package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitInfoConverter {
    List<Fruit> convertFruitInfo(String data);
}
