package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            if (line.isBlank() || line.startsWith(HEADER)) {
                continue;
            }
            String[] parts = line.split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperationByCode(parts[OPERATION_INDEX].trim());
            String fruitName = parts[FRUIT_INDEX].trim();
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
            if (quantity < 0) {
                throw new RuntimeException("Quantity cannot be negative: " + quantity);
            }
            transactions.add(new FruitTransaction(operation, fruitName, quantity));
        }
        return transactions;
    }
}
