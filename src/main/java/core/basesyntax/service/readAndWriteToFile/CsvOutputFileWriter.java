package core.basesyntax.service.readAndWriteToFile;

import java.util.Map;

public interface CsvOutputFileWriter {
    void createCscWithTitle();
    void saveReportToCsv(Map<String, Integer> fruits);
}
