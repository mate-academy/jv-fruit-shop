package core.basesyntax.service;

import core.basesyntax.DataConverter;
import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_HEADER = "type,fruit,quantity";
    private static final int MAX_NUMBER_OF_PARTS = 3;
    private static final int INDEX_OF_TYPE_CODE = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line.trim().isEmpty() || line.equals(CSV_HEADER)) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length != MAX_NUMBER_OF_PARTS) {
                throw new RuntimeException(
                        "Invalid line format: expected format <type,fruit,quantity>, got: " + line);
            }
            String typeCode = parts[INDEX_OF_TYPE_CODE];
            String fruit = parts[INDEX_OF_FRUIT];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[INDEX_OF_QUANTITY]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity: " + parts[INDEX_OF_QUANTITY], e);
            }
            FruitTransaction.Operation operation = FruitTransaction.fromCode(typeCode);
            FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
