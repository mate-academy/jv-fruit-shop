package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeInCsvFile(List<String> report, String fileName);
}
