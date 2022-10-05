package core.basesyntax.fileService;

import java.nio.file.Path;

public interface CsvFileWriterService {
    void writeToFile(String info, Path path);
}
