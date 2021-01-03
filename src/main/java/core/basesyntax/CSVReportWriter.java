package core.basesyntax;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CSVReportWriter implements ReportWriter {
    private final String reportFilePath = "src/main/resources/report.csv";
    private final String[] header = new String[]{"fruit", "quantity"};

    @Override
    public void writeReport() {
        try {
            CSVWriter csvWriter = new CSVWriter(Files.newBufferedWriter(Path.of(reportFilePath)),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            csvWriter.writeNext(header);
            for (Map.Entry<String, Integer> entry : Warehouse.getStorage().entrySet()) {
                csvWriter.writeNext(new String[]{entry.getKey(),
                        String.valueOf(entry.getValue())});
            }
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file", e);
        }
    }
}
