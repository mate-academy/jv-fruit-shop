package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.Operation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<FruitTransaction> read(File file) {
        List<String> transactionsData;
        try {
            transactionsData = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from File " + file.getName(), e);
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
