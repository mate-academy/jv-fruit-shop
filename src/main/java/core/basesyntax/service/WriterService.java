package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface WriterService {
    void writeToFile(List<Fruit> fruits);
}
