package core.basesyntax.data.csv.impl;

import core.basesyntax.data.csv.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements FileReader {
    private static final int CSV_HEADER_POSITION_IN_READ_LINES = 0;
    private final Path pathToCsv;

    public CsvFileReaderImpl(String pathToCsv) {
        this.pathToCsv = Path.of(pathToCsv);
    }

    @Override
    public List<String> readAll() {
        try {
            List<String> linesFromCsv = Files.readAllLines(pathToCsv);
            linesFromCsv.remove(CSV_HEADER_POSITION_IN_READ_LINES);
            return linesFromCsv;
        } catch (IOException e) {
            throw new RuntimeException("Problems when trying to read from file: ", e);
        }
    }
}
