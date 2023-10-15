package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String SEPARATOR = ",";
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public ArrayList<FruitTransaction> readFromFile(File file) {
        ArrayList<FruitTransaction> fruitTransactions = new ArrayList<>();
        try {
            List<String> fruits = Files.readAllLines(file.toPath());
            fruits.remove(HEADER_INDEX);
            for (String fruit: fruits) {
                String[] parsedFruit = fruit.split(SEPARATOR);
                fruitTransactions.add(new FruitTransaction(parsedFruit[FRUIT_INDEX],
                        Integer.parseInt(parsedFruit[AMOUNT_INDEX]),
                        FruitTransaction.Operation.getByCode(parsedFruit[OPERATION_INDEX])));
            }
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot read data from file: " + file, ioException);
        }
        return fruitTransactions;
    }
}
