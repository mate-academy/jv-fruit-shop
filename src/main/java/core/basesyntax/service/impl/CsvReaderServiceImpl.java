package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.strategy.OperationParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {
    private static final OperationParser OPERATION_PARSER = new OperationParser();
    private static final int INVALID_CSV_LENGTH = 3;
    private static final int OPERATION_CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(DELIMITER);
                if (parts.length != INVALID_CSV_LENGTH) {
                    throw new RuntimeException("Invalid CSV format: " + line);
                }

                String operationCode = parts[OPERATION_CODE_INDEX].trim();
                String fruit = parts[FRUIT_INDEX].trim();
                int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());

                FruitTransaction.Operation operation = OPERATION_PARSER
                        .parseOperationFromCode(operationCode);
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error in CsvReaderServiceImpl : ", e);
        }

        return transactions;
    }
}
