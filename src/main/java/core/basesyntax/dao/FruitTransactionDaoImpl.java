package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> getAllTransactions(String fileName) {
        try {
            List<String> stringList = Files.readAllLines(Path.of(fileName));
            stringList.remove(0);
            List<String[]> lines = stringList.stream()
                    .map(f -> f.split(","))
                    .toList();
            return convertToTransactionsList(lines);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
    }

    private static List<FruitTransaction> convertToTransactionsList(List<String[]> lines) {
        return lines.stream()
                .map(f -> new FruitTransaction(OperationStrategy.getOperation(f[TYPE]),
                        f[FRUIT],
                        Integer.parseInt(f[QUANTITY])))
                .collect(Collectors.toList());
    }
}
