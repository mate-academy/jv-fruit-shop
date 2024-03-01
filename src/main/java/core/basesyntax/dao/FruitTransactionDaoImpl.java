package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    private static int ONE = 1;
    private static String SEPARATOR = ",";

    @Override
    public List<String[]> getAllTransactions(String fileName) {
        try {
            List<String> stringList = Files.readAllLines(Path.of(fileName));
            return stringList.stream().skip(ONE)
                    .map(line -> line.split(SEPARATOR))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file from "
                    + this.getClass().getSimpleName(), e);
        }
    }
}
