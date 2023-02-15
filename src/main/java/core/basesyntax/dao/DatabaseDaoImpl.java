package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DatabaseDaoImpl implements DatabaseDao {
    private static final String DATABASE_FILE_NAME = "database.csv";

    @Override
    public List<String> get() {
        List<String> operations;
        try {
            operations = Files.readAllLines(Path.of(DATABASE_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + DATABASE_FILE_NAME);
        }
        return operations;
    }
}
