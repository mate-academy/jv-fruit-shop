package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    public List<FruitTransaction> readTransactionsFromFile(String filePath) throws IOException {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    if (parts.length < 3) {
                        throw new IllegalArgumentException("Invalid line format: " + line);
                    }
                    FruitTransaction transaction = new FruitTransaction(
                            FruitTransaction.Operation.fromString(parts[0]),
                            parts[1],
                            Integer.parseInt(parts[2])
                    );
                    transactions.add(transaction);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Failed to parse line: " + line, e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + filePath);
        } catch (IOException e) {
            throw new IOException("An I/O error occurred while reading the file: " + filePath, e);
        }

        return transactions;
    }
}
