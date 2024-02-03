package core.basesyntax.db.csv.impl;

import core.basesyntax.db.csv.Writer;
import core.basesyntax.model.FruitResultingRow;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvWriterImpl implements Writer<FruitResultingRow> {
    private final Path pathToCsv;
    private final String columnNames;

    public CsvWriterImpl(String pathToCsv, String columnNames) {
        this.columnNames = columnNames;
        this.pathToCsv = Path.of(pathToCsv);
    }

    @Override
    public void writeAll(List<FruitResultingRow> records) {
        List<String> recordsInCsv = records
                .stream()
                .map(FruitResultingRow::toCsv)
                .collect(Collectors.toList()); // Collect stream elements into a list
        // Add string at the beginning of array, so it will be added to the start of file
        // That string contains informative column names for CSV files
        recordsInCsv.add(0, columnNames);

        try {
            // The File will be rewritten every time a user asks for stat
            Files.write(pathToCsv, recordsInCsv);
        } catch (IOException e) {
            throw new RuntimeException("Problems while writing data to CSV file: ", e);
        }
    }
}
