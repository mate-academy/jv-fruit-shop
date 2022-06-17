package core.basesyntax.service;

import java.util.List;

public interface CsvFileWriter {
    void write(List<String> generatedFruitReport, String pathname);
}
