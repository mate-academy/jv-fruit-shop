package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataAddService;
import core.basesyntax.service.DataReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

public class DataReaderServiceImpl implements DataReaderService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int MAX_PARTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private final DataAddService dataAddService = new DataAddServiceImpl();

    @Override
    public void readDataFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            getLinesFromFile(reader);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
    }

    private void getLinesFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(SPLIT_SYMBOL);
            if (parts.length == MAX_PARTS) {
                FruitTransaction.Operation operation = parseOperation(parts[OPERATION_INDEX]
                        .trim());
                String fruit = parts[FRUIT_INDEX].trim();
                int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
                FruitTransaction fruitTransaction = new FruitTransaction(operation,
                        fruit, quantity);
                dataAddService.addData(Collections.singletonList(fruitTransaction));
            } else {
                throw new IOException("Invalid line format: " + line);
            }
        }
    }

    private FruitTransaction.Operation parseOperation(String operationCode) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(operationCode)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + operationCode);
    }
}
