package core.basesyntax.fileservise;

import java.util.List;

public interface CsvFileWriter {
    void writeToFile(List<String> report, String toFile);
}
