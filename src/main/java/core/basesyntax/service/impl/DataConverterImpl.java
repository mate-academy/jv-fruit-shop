package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    private static final int EXPECTED_COLUMNS = 3;

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> input) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < input.size(); i++) {
            String line = input.get(i);

            try {
                String[] parts = line.split(",");

                if (parts.length != EXPECTED_COLUMNS) {
                    throw new RuntimeException("Invalid line format: " + line);
                }

                String operation = parts[0];
                String fruit = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                transactions.add(
                        new FruitTransaction(operation, fruit, quantity)
                );

            } catch (Exception e) {
                throw new RuntimeException(
                        "Error parsing line: " + line, e
                );
            }
        }

        return transactions;
    }
}
