package core.basesyntax.service.io.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Product;
import core.basesyntax.service.io.ReportWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CSVReportWriter<T extends Product> implements ReportWriter<T> {
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private final String[] header = new String[]{"fruit", "quantity"};

    @Override
    public void writeReport(Warehouse<T> warehouse) {
        try (CSVWriter csvWriter = new CSVWriter(Files.newBufferedWriter(Path.of(REPORT_FILE_PATH)),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(header);
            for (Map.Entry<T, Integer> entry : warehouse.getStorage().entrySet()) {
                csvWriter.writeNext(new String[]{entry.getKey().getName(),
                        String.valueOf(entry.getValue())});
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file", e);
        }
    }
}
