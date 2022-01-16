package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitsConsumer {
    void accept(List<Fruit> fruits);
}
