package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            try {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Invalid data format: " + line);
                }
                FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
                String fruit = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format in line: " + line);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.err.println("Error processing line: " + line + " - " + e.getMessage());
            }
        }
        return transactions;
    }
}
