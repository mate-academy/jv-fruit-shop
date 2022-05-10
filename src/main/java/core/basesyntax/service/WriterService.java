package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.io.File;
import java.util.Map;

public interface WriterService {
    File writeData(File file, Map<Fruit, Integer> fruitIntegerMap);
}
