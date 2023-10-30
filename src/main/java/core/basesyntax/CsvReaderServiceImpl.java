package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {
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

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new RuntimeException("Invalid CSV format: " + line);
                }

                String operationCode = parts[0].trim();
                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());

                FruitTransaction.Operation operation = getOperationFromCode(operationCode);
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    private FruitTransaction.Operation getOperationFromCode(String code) {
        return switch (code) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new IllegalArgumentException("Invalid operation code: " + code);
        };
    }
}
