package core.basesyntax.utils.filereader;

import java.nio.file.Path;
import java.util.List;

public interface IFileReader {
    List<String> readCsvFile(Path path);
}
