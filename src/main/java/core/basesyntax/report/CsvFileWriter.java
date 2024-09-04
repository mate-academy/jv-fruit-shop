package core.basesyntax.report;

import core.basesyntax.exceptions.FileWasNotWrittenException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriter {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private final String filePath;

    public CsvFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeReport(Map<String, Integer> reportData) {
        try (FileWriter writer = new FileWriter(filePath)) {
            StringBuilder report = new StringBuilder();
            report
                    .append(REPORT_HEADER)
                    .append(System.lineSeparator());
            for (Map.Entry<String, Integer> pair : reportData.entrySet()) {
                report
                        .append(pair.getKey())
                        .append(COMMA)
                        .append(pair.getValue())
                        .append(System.lineSeparator());
            }
            writer.write(report.toString());
        } catch (IOException e) {
            throw new FileWasNotWrittenException(e.getMessage());
        }
    }
}
