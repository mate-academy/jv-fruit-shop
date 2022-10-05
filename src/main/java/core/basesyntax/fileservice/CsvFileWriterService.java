package core.basesyntax.fileservice;

import java.nio.file.Path;
public interface CsvFileWriterService {
    void writeToFile(String info, Path path);
}
