package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_DELIMITER = ",";
    private static final String HEADER_PREFIX = "type";

    @Override
    public List<FruitTransaction> convert(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        if (data == null || data.isEmpty()) {
            return transactions;
        }

        for (String line : data) {
            String processedLine = line.trim();
            if (processedLine.isEmpty()) {
                continue;
            }

            if (processedLine.startsWith(HEADER_PREFIX)
                    && processedLine.split(CSV_DELIMITER)[0]
                    .equalsIgnoreCase(HEADER_PREFIX)) {
                continue;
            }

            String[] parts = processedLine.split(CSV_DELIMITER);
            if (parts.length != 3) {
                throw new RuntimeException("Invalid data format in line: '" + line
                        + "'. Expected 'type,fruit,quantity'.");
            }

            try {
                String operationCode = parts[0];
                String fruitName = parts[1];
                String quantityString = parts[2];

                if (operationCode.contains(" ") || fruitName.contains(" ")
                        || quantityString.contains(" ")) {
                    throw new RuntimeException("Invalid data format: "
                            + "fields contain unexpected spaces. Line: '" + line + "'");
                }

                int quantity = Integer.parseInt(quantityString);

                FruitTransaction.Operation operation = FruitTransaction
                        .Operation.getByCode(operationCode);
                transactions.add(new FruitTransaction(operation, fruitName, quantity));

            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format in line: '" + line + "'", e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid operation code in line: '" + line + "'", e);
            }
        }

        return transactions;
    }
}
