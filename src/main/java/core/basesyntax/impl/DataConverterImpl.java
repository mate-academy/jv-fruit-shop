package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_ROW_INDEX = 0;
    private static final int EXPECTED_COLUMNS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactionFile) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < transactionFile.size(); i++) {
            String line = transactionFile.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] fields = line.split(CSV_DELIMITER);
            if (fields.length != EXPECTED_COLUMNS) {
                throw new IllegalArgumentException("Invalid CSV format at line "
                        + (i + 1) + ": " + line);
            }

            FruitTransaction transaction = parseTransaction(fields, i + 1);
            transactions.add(transaction);
        }
        return transactions;
    }

    private FruitTransaction parseTransaction(String[] fields, int lineNumber) {
        try {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(fields[OPERATION_INDEX].trim());
            String fruit = fields[FRUIT_INDEX].trim();
            int quantity = Integer.parseInt(fields[QUANTITY_INDEX].trim());

            return new FruitTransaction(operation, fruit, quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number at line "
                    + lineNumber + ": " + fields[QUANTITY_INDEX]);
        }
    }
}
