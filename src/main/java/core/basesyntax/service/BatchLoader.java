package core.basesyntax.service;

import core.basesyntax.model.FruitCrate;
import java.util.List;

public interface BatchLoader {
    List<FruitCrate> loadBatch(List<String> fileData);
}
