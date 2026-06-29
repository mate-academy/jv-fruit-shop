package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER_FIRST_WORD = "type";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith(HEADER_FIRST_WORD) || line.isBlank()) {
                continue;
            }
            String[] parts = line.split(CSV_SEPARATOR);
            String operationCode = parts[TYPE_INDEX].trim();
            String fruit = parts[FRUIT_INDEX].trim();

            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format in line: " + line, e);
            }

            if (quantity < 0) {
                throw new RuntimeException("Quantity cannot be negative for fruit: " + fruit);
            }

            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.getByCode(operationCode);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}


