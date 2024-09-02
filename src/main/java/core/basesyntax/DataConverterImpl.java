package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String LINE_SKIP_STRING = "type";
    private static final String SPLIT_VALUE = ",";
    private static final int EXPECTED_DATA_LENGTH = 3;
    private static final int QUANTITY_INDEX = 2;
    private static final int FRUIT_INDEX = 1;
    private static final int OPERATION_INDEX = 0;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith(LINE_SKIP_STRING)) {
                continue;
            }
            String[] parts = line.split(SPLIT_VALUE);
            if (parts.length < EXPECTED_DATA_LENGTH) {
                throw new RuntimeException(
                        "Invalid input data format. Expected at least 3 parts");
            }
            FruitTransaction.Operation operation
                        = FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
            if (operation == null) {
                throw new IllegalArgumentException(
                        "Invalid operation code: " + parts[OPERATION_INDEX]);
            }
            String fruit = parts[FRUIT_INDEX];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid quantity format: " + parts[QUANTITY_INDEX], e);
            }
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
