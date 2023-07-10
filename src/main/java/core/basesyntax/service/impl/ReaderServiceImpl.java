package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String COMMA = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(COMMA);
                if (data[OPERATION].equals("type")) {
                    continue;
                }
                FruitTransaction.Operation operation = getOperation(data[OPERATION].trim());
                String fruit = data[FRUIT];
                int quantity = Integer.parseInt(data[QUANTITY]);

                transactions.add(new FruitTransaction(operation, fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from file: " + filePath, e);
        }

        return transactions;
    }

    private FruitTransaction.Operation getOperation(String operationCode) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(operationCode)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + operationCode);
    }
}
