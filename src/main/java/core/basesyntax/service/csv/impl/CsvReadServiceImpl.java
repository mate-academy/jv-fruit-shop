package core.basesyntax.service.csv.impl;

import core.basesyntax.service.csv.CsvService;
import core.basesyntax.service.csv.ReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReadServiceImpl extends CsvService implements ReadService {
    public CsvReadServiceImpl(String inputPath) {
        super(inputPath);
    }

    @Override
    public List<String> read() {
        List<String> rows;
        try {
            rows = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file by path: " + path, e);
        }
        return rows;
    }
}
