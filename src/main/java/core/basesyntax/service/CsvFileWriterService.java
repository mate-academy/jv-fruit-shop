package core.basesyntax.service;

import java.util.List;

public interface CsvFileWriterService {
    void writeFile(List<String> lines, String fileName);
}
