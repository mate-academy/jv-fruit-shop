package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRider {
    public List<FruitTransaction> readTransactions(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();
            while ((line = br.readLine()) != null) {
                try {
                    FruitTransaction transaction = parseTransaction(line);
                    transactions.add(transaction);
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    private FruitTransaction parseTransaction(String line) {
        String[] values = line.split(",");
        if (values.length != 3) {
            throw new IllegalArgumentException("Invalid input format");
        }
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.fromCode(values[0].trim());
        String fruit = values[1].trim();
        int quantity = Integer.parseInt(values[2].trim());
        return new FruitTransaction(operation, fruit, quantity);
    }
}
