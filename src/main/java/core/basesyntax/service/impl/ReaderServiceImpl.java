package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final String COMA = ",";
    private static final String TYPE = "type";

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + filePath);
        }
        return strings.stream().map(this::getFromCsvRow).collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(COMA);
        if (fields[0].equals(TYPE)) {
            return null;
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = fruitTransaction.getOperationCode(fields[0]);
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        Storage.fruitTransactions.add(fruitTransaction);
        return fruitTransaction;
    }
}
