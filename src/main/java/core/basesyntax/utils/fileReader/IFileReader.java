package core.basesyntax.utils.fileReader;

import java.nio.file.Path;
import java.util.List;

public interface IFileReader {
    List<String> readCSVFile(Path path);
}
