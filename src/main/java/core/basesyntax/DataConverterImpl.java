package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String LINE_SKIP_STRING = "type";
    private static final String SPLIT_VALUE = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith(LINE_SKIP_STRING)) {
                continue;
            }
            String[] parts = line.split(SPLIT_VALUE);
            if (parts.length < 3) {
                throw new RuntimeException("Invalid input data format. Expected at least 3 parts");
            }
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
            if (operation == null) {
                throw new IllegalArgumentException("Invalid operation code: " + parts[0]);
            }
            String fruit = parts[1];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format: " + parts[2], e);
            }
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
