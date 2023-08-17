package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<String> rowsFile;
        try {
            rowsFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + filePath);
        }
        return rowsFile.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        if (fields[0].equals("type")) {
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
