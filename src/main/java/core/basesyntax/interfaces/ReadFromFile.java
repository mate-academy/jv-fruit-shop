package core.basesyntax.interfaces;

import core.basesyntax.FruitRecord;
import java.util.List;

public interface ReadFromFile {
    List<FruitRecord> read(String pathToFile);
}
