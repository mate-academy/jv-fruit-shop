package core.basesyntax.file.writer;

import java.io.File;
import java.util.List;

public interface CsvFileWriter {
    void writeDataToFile(File file, List<String> report);
}
