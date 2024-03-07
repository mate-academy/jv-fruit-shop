package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.Fruit;

public interface WriterService {
    void writeToFile(String pathToFile, List<Fruit> fruits);
}
