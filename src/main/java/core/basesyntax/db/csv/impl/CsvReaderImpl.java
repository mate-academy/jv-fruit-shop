package core.basesyntax.db.csv.impl;

import core.basesyntax.db.csv.Reader;
import core.basesyntax.model.FruitTransactionRow;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderImpl implements Reader<FruitTransactionRow> {

    private final Path pathToCsv;

    public CsvReaderImpl(String pathToCsv) {
        this.pathToCsv = Path.of(pathToCsv);
    }

    @Override
    public List<FruitTransactionRow> readAll() {
        try {
            return Files.readAllLines(pathToCsv)
                    .stream()
                    .skip(1) // Skipping columns info
                    .map(FruitTransactionRow::of)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Problems when trying to read file: ", e);
        }
    }
}
