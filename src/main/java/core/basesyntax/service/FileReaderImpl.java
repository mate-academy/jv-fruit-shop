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
    public List<String> readFromFile(File file) {
        ArrayList<FruitTransaction> fruitTransactions = new ArrayList<>();
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot read data from file: " + file, ioException);
        }
    }
}
