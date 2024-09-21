package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.DataConverter;
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
                Operation operation = Operation.getByCode(parts[0].trim());
                if (operation == null) {
                    throw new IllegalArgumentException("Invalid operation code at line "
                            + (i + 1) + ": " + parts[0].trim());
                }

                String fruit = parts[1].trim();
                if (fruit.isEmpty()) {
                    throw new IllegalArgumentException("Fruit cannot be empty at line "
                            + (i + 1) + ": " + line);
                }

                int quantity = Integer.parseInt(parts[2].trim());
                if (quantity < 0) {
                    throw new IllegalArgumentException("Quantity must be non-negative at line "
                            + (i + 1) + ": " + line);
                }

                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity at line "
                        + (i + 1) + ": " + line, e);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException("Error processing line "
                        + (i + 1) + ": " + line, e);
            }
        }

        return transactions;
    }
}

