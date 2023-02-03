package core.basesyntax.service.readandwritetofile;

import java.util.Map;

public interface CsvOutputFileWriter {
    void createCscWithTitle();

    void saveReportToCsv(Map<String, Integer> fruits);
}
