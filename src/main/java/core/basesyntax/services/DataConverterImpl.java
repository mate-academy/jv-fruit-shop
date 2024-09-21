package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(",");

            if (parts.length < 3) {
                throw new IllegalArgumentException("Invalid data format at line "
                        + (i + 1) + ": " + line);
            }

            try {
                FruitTransaction.Operation operation
                        = FruitTransaction.Operation.getByCode(parts[0].trim());
                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());

                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity at line "
                        + (i + 1) + ": " + line, e);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error processing line "
                        + (i + 1) + ": " + line, e);
            }
        }

        return transactions;
    }
}

