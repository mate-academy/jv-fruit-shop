package core.basesyntax.dao;

import core.basesyntax.service.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class WarehouseDaoRead {
    public static List<FruitTransaction> readData(String fileName) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

        List<FruitTransaction> fruitTransactionList = lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(array -> new FruitTransaction(FruitTransaction.Operation.getByCode(
                        array[0].replaceAll("\\s", "")),
                        array[1], Integer.parseInt(array[2])))
                .collect(Collectors.toList());
        return fruitTransactionList;
    }
}
