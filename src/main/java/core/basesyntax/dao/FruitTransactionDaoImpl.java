package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public List<FruitTransaction> getAllTransactions(String fileName) {
        try {
            List<String> stringList = Files.readAllLines(Path.of("src/" + fileName));
            stringList.remove(0);
            return stringList.stream()
                    .map(f -> f.split(","))
                    .map(f -> new FruitTransaction(FruitTransaction.Operation.getOperation(f[0]),
                            f[1],
                            Integer.parseInt(f[2])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
    }
}
