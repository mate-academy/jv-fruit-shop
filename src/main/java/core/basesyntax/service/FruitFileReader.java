package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FruitFileReader {
    List<String> read(Path path);
}
