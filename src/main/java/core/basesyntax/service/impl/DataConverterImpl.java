package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private final Parser parser = new Parser();

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        List<String[]> parsedDate = parser.parse(inputReport);

        for (String[] parts : parsedDate) {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(parts[INDEX_OPERATION]);
            if (operation == null) {
                throw new RuntimeException("Invalid operation: " + parts[INDEX_OPERATION]);
            }
            String fruit = parts[INDEX_FRUIT];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[INDEX_QUANTITY]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity: " + parts[INDEX_QUANTITY], e);
            }

            if (quantity < 0) {
                throw new RuntimeException("Quantity cannot be negative: " + quantity);
            }

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
