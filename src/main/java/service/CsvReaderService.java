package service;

import core.basesyntax.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService {
    public List<FruitTransaction> readTransactions(String filePath) throws IOException {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());
                transactions.add(new FruitTransaction(FruitTransaction.Operation.fromCode(type),
                        fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file", e);
        }
        return transactions;
    }
}
