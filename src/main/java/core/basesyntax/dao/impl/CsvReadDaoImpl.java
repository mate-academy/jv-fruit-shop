package core.basesyntax.dao.impl;

import core.basesyntax.dao.CsvDao;
import core.basesyntax.dao.ReadDao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReadDaoImpl extends CsvDao implements ReadDao {
    public CsvReadDaoImpl(String inputPath) {
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
