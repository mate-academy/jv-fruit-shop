package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    public static final String SEPARATOR = ",";
    public static final int ELEMENTS_IN_A_ROW = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(SEPARATOR);

            if (parts.length != ELEMENTS_IN_A_ROW) {
                throw new IllegalArgumentException(
                        "Invalid data format: "
                                + line + ". Should be "
                                + ELEMENTS_IN_A_ROW + " elements in a row."
                );
            }

            try {
                FruitTransaction.Operation operation =
                        FruitTransaction.Operation.getOperation(parts[0].trim().toLowerCase());

                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());

                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Error parsing line: " + line, e);
            }
        }

        return transactions;
    }
}
