package service;

import core.basesyntax.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService {
    private static final int TYPE_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    public List<FruitTransaction> readTransactions(String filePath) throws IOException {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[TYPE_COLUMN].trim();
                String fruit = parts[FRUIT_COLUMN].trim();
                int quantity = Integer.parseInt(parts[QUANTITY_COLUMN].trim());
                transactions.add(new FruitTransaction(FruitTransaction.Operation.fromCode(type),
                        fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file", e);
        }
        return transactions;
    }
}
