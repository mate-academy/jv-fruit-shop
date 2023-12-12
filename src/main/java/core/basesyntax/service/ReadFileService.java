package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReadFileService {
    List<Fruit> readFile(String path);
}
