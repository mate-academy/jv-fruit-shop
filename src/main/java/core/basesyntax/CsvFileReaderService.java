package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService implements TransactionReader {
    private static final String SEPARATOR = ",";
    private static final int REPORT_LENGTH = 3;
    private static final int TYPE_OF_ACTIVITIES = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;

    @Override
    public List<FruitTransaction> readTransactions(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(SEPARATOR);
                if (values.length == REPORT_LENGTH) {
                    String operationCode = values[TYPE_OF_ACTIVITIES].trim();
                    String fruit = values[TYPE_OF_FRUIT].trim();
                    int quantity = Integer.parseInt(values[AMOUNT].trim());

                    FruitTransaction.Operation operation = getOperationByCode(operationCode);
                    FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }

        return transactions;
    }

    private FruitTransaction.Operation getOperationByCode(String code) {
        switch (code) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new IllegalArgumentException("Unknown operation code: " + code);
        }
    }
}
