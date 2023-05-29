package core.basesyntax.service;

import java.util.List;

public interface CsvFileWriter {
    public void writeFile(List<String> lines, String fileName);
}
