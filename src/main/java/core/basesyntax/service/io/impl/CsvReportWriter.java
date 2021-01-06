package core.basesyntax.service.io.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.ReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReportWriter implements ReportWriter {
    private static final String[] HEADER = new String[]{"fruit", "quantity"};

    @Override
    public void writeReport(Path pathToFile, List<String[]> report) {
        validateFileExtension(pathToFile);
        try (CSVWriter csvWriter = new CSVWriter(Files.newBufferedWriter(pathToFile),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(HEADER);
            for (String[] row : report) {
                csvWriter.writeNext(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file", e);
        }
    }

    private boolean validateFileExtension(Path pathToFile) {
        if (!pathToFile.toString().endsWith(".csv")) {
            throw new InvalidFileExtensionException("This reader works with .csv files only");
        }
        return true;
    }
}
