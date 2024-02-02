package core.basesyntax.db.csv.impl;

import core.basesyntax.db.csv.Writer;
import core.basesyntax.model.FruitResultingRow;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvWriterImpl implements Writer<FruitResultingRow> {
    private static final String columnNames = "fruit,quantity";
    private final Path pathToCsv;

    public CsvWriterImpl(String pathToCsv) {
        this.pathToCsv = Path.of(pathToCsv);
    }

    private void createFileWithColumnInfoIfNotPresent() throws IOException {
        if (!Files.exists(pathToCsv)) {
            Files.write(pathToCsv, columnNames.getBytes());
        }
    }

    @Override
    public void writeAll(List<FruitResultingRow> records) {
        List<String> recordsInCsv = records
                .stream()
                .map(FruitResultingRow::toCsv)
                .toList();

        try {
            createFileWithColumnInfoIfNotPresent();
            Files.write(pathToCsv, recordsInCsv);
        } catch (IOException e) {
            throw new RuntimeException("Problems while writing data to CSV file: ", e);
        }
    }
}
