package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public static final String LINE_SKIP_STRING = "type";
    public static final String SPLIT_VALUE = ",";
    public static final int EXPECTED_DATA_LENGTH = 3;
    public static final int QUANTITY_INDEX = 2;
    public static final int FRUIT_INDEX = 2;
    public static final int OPERATION_INDEX = 0;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith(LINE_SKIP_STRING)) {
                continue;
            }
            String[] parts = line.split(SPLIT_VALUE);
            if (parts.length < EXPECTED_DATA_LENGTH) {
                throw new RuntimeException("Invalid input data format. Expected at least 3 parts");
            }
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
            if (operation == null) {
                throw new IllegalArgumentException("Invalid operation: " + parts[OPERATION_INDEX]);
            }
            String fruit = parts[FRUIT_INDEX];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantuty format: "
                        + parts[QUANTITY_INDEX], e);
            }
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
