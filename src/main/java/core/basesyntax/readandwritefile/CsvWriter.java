package core.basesyntax.readandwritefile;

import java.util.List;

public interface CsvWriter {
    public void writeReportToFile(List<String> report, String filePath);
}
