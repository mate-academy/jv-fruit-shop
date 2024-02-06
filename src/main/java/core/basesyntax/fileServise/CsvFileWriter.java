package core.basesyntax.fileServise;

import java.util.List;

public interface CsvFileWriter {
    void writeToFile(List<String> report, String toFile);
}
