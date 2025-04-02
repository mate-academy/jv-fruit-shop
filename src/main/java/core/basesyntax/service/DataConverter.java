package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {

    private static final String DELIMITER = ",";

    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> convertDataToTransactions(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : data) {
            String[] row = line.split(DELIMITER);
            if (row.length != 3) {
                throw new IllegalArgumentException(
                        "Invalid data format, expected 3 fields per line but received: "
                        + row.length);
            }

            String operation = row[OPERATION_INDEX];
            String fruit = row[FRUIT_INDEX];

            int quantity;
            try {
                quantity = Integer.parseInt(row[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format for fruit: "
                        + fruit, e);
            }
            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }

        return transactions;
    }
}
