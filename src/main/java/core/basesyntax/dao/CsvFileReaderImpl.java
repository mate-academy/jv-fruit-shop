package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String ERROR_MESSAGE = "Can`t read data from CSV file ";
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> readTransactions(String fromFileName) {
        List<String> fruits = new ArrayList<>();
        try {
            fruits = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + fromFileName, e);
        }
        fruits.remove(OPERATION_INDEX);
        return fruits.stream()
                .map(line -> parseTransaction(line.trim()))
                .collect(Collectors.toList());
    }

    private FruitTransaction parseTransaction(String line) {
        String[] fields = line.split(SPLIT_SYMBOL);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation.getByCode(fields[OPERATION_INDEX].toUpperCase()));
        fruitTransaction.setFruit(fields[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
