package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String HEADER_MARKER = "type";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Input data is null or empty");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[OPERATION_INDEX].trim().equals(HEADER_MARKER)) {
                continue;
            }
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX].trim());
            String fruit = parts[FRUIT_INDEX].trim();
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
            if (quantity < 0) {
                throw new RuntimeException("Quantity can't be negative: " + quantity);
            }
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
