package core.basesyntax;

import java.nio.file.Path;
import java.util.List;

public interface ReadDataFromFile {
    List<String> readData(Path path);
}
