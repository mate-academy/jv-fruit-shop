package core.basesyntax.service.io;

import java.nio.file.Path;
import java.util.List;

public interface DataReader {
    List<String[]> readData(Path pathToFile);
}
