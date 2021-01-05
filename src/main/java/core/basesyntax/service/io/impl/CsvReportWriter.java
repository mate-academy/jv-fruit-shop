package core.basesyntax.service.io.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Product;
import core.basesyntax.model.entities.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.ReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CsvReportWriter<T extends Product> implements ReportWriter<T> {
    private static final String[] HEADER = new String[]{"fruit", "quantity"};
    private final String reportFilePath;

    public CsvReportWriter(String reportFilePath) {
        this.reportFilePath = reportFilePath;
        validateFileExtension();
    }

    @Override
    public void validateFileExtension() {
        if (!reportFilePath.endsWith(".csv")) {
            throw new InvalidFileExtensionException("This reader works with .csv files only");
        }
    }

    @Override
    public void writeReport(Warehouse<T> warehouse) {
        try (CSVWriter csvWriter = new CSVWriter(Files.newBufferedWriter(Path.of(reportFilePath)),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(HEADER);
            for (Map.Entry<T, Integer> entry : warehouse.getStorage().entrySet()) {
                csvWriter.writeNext(new String[]{entry.getKey().getName(),
                        String.valueOf(entry.getValue())});
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file", e);
        }
    }
}
