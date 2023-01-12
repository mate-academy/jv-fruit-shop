package core.basesyntax.csv.reader;

import java.nio.file.Path;

public interface WriteToFile {
    void writeFile(Path path, String data);
}
