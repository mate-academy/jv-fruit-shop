package core.basesyntax.db.csv.impl;

import core.basesyntax.db.csv.Writer;
import core.basesyntax.model.FruitResultingRow;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvWriterImpl implements Writer<FruitResultingRow> {
    private static final int POSITION_OF_CSV_HEADER_STRING = 0;
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
                .collect(Collectors.toList());
        recordsInCsv.add(POSITION_OF_CSV_HEADER_STRING, columnNames);

        try {
            Files.write(pathToCsv, recordsInCsv); // rewrites, not appends
        } catch (IOException e) {
            throw new RuntimeException("Problems while writing data to CSV file: ", e);
        }
    }
}
