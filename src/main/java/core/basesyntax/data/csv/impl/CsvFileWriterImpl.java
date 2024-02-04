package core.basesyntax.data.csv.impl;

import core.basesyntax.data.csv.FileWriter;
    import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileWriterImpl implements FileWriter {
    private final Path pathToCsv;
    private final String headerColumnNames;

    public CsvFileWriterImpl(String pathToCsv, String columnNames) {
        this.headerColumnNames = columnNames;
        this.pathToCsv = Path.of(pathToCsv);
    }

    @Override
    public void writeAll(List<String> lines) {
        lines.add(0, headerColumnNames); // add column names as csv header
        try {
            Files.write(pathToCsv, lines); // rewrites, not appends
        } catch (IOException e) {
            throw new RuntimeException("Problems while writing data to CSV file: ", e);
        }
    }
}
