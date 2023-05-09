package core.basesyntax.dao;

import core.basesyntax.service.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class WarehouseDaoReader {
    private static final String SEPARATOR = ",";
    private static final int SKIP_LINE = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QTE_INDEX = 2;

    public List<FruitTransaction> readData(String fileName) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

        List<FruitTransaction> fruitTransactionList = lines.stream()
                .skip(SKIP_LINE)
                .map(line -> line.split(SEPARATOR))
                .map(array -> new FruitTransaction(FruitTransaction.Operation.getByCode(
                        array[OPERATION_INDEX].trim()),
                        array[FRUIT_INDEX], Integer.parseInt(array[QTE_INDEX])))
                .collect(Collectors.toList());
        return fruitTransactionList;
    }
}
