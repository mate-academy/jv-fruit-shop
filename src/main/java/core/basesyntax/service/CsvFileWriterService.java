package core.basesyntax.service;

import java.util.List;

public interface CsvFileWriterService {
    public void writeFile(List<String> lines, String fileName);
}
