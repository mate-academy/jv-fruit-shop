package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.Operation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<FruitTransaction> read(String filePath) {
        List<String> transactionsData;
        try {
            transactionsData = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from File " + filePath, e);
        }
        return transactionsData.stream()
                .map(this::getFromString)//
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromString(String line) {
        String[] fields = line.split(",");
        Operation operation = Operation.getEnumByTitle(fields[0]);
        String fruitName = fields[1];
        int quantity = Integer.parseInt(fields[2]);
        return new FruitTransaction(operation, fruitName, quantity);
    }
}
