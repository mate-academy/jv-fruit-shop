package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService implements ReaderService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> readFromFile(final String filePath) {
        File file = new File(filePath);
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            List<FruitTransaction> transactions = new ArrayList<>();
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                transactions.add(getTransaction(line));
                line = bufferedReader.readLine();
            }
            return transactions;
        } catch (IOException e) {
            throw new RuntimeException("File " + e + " not found.");
        }
    }

    private FruitTransaction getTransaction(String line) {
        if (line != null) {
            final String[] data = line.split(",");
            Operation operation = Operation.get(data[OPERATION_INDEX]);
            Fruit fruit = new Fruit(data[FRUIT_INDEX]);
            int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
            return new FruitTransaction(operation, fruit, quantity);
        }
        throw new RuntimeException("Line is null.");
    }
}
