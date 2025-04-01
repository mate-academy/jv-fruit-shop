package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {

    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public static List<String[]> convertLinesToData(BufferedReader reader) throws IOException {
        List<String[]> data = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            if (row.length == 3) {
                data.add(row);
            } else {
                System.err.println("Invalid row format, skipping: " + line);
            }
        }
        return data;
    }

    public List<FruitTransaction> convertDataToTransactions(List<String[]> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String[] row : data) {
            if (row.length != 3) {
                throw new IllegalArgumentException("Invalid data format, expected per row, got: "
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
