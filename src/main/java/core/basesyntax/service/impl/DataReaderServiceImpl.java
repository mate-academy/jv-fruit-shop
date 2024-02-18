package core.basesyntax.service.impl;

import static core.basesyntax.model.FruitTransaction.Operation.parseOperation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderServiceImpl implements DataReaderService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int MAX_PARTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> readDataFromFile(String fileName) {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(processLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
        return transactions;
    }

    private FruitTransaction processLine(String line) throws IOException {
        String[] parts = line.split(SPLIT_SYMBOL);
        if (parts.length != MAX_PARTS) {
            throw new IOException("Invalid line format: " + line);
        }
        FruitTransaction.Operation operation = parseOperation(parts[OPERATION_INDEX].trim());
        String fruit = parts[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
        return new FruitTransaction(operation, fruit, quantity);
    }
}
