package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public List<String[]> getAllTransactions(String fileName) {
        try {
            List<String> stringList = Files.readAllLines(Path.of(fileName));
            stringList.remove(0);
            return stringList.stream()
                    .map(f -> f.split(","))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
    }
}
