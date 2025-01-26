package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransactions(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Input lines cannot be null or empty");
        }

        List<FruitTransaction> transactions = new ArrayList<>();
        // Skip header
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line format at line " + (i + 1));
            }

            String operationCode = parts[0].trim();
            String fruit = parts[1].trim();
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2].trim());
                if (quantity < 0) {
                    throw new IllegalArgumentException("Quantity cannot be negative at line "
                            + (i + 1));
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format at line " + (i + 1));
            }

            transactions.add(new FruitTransaction(
                    FruitTransaction.Operation.fromCode(operationCode),
                    fruit,
                    quantity
            ));
        }
        return transactions;
    }
}
