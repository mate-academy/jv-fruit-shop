package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int MAX_NUMBER_OF_PARTS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line.trim().isEmpty() || line.startsWith("type")) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length != MAX_NUMBER_OF_PARTS) {
                throw new RuntimeException("Invalid line format" + line);
            }
            String typeCode = parts[0];
            String fruit = parts[1];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quanity: " + parts[2], e);
            }
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(typeCode);
            FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
