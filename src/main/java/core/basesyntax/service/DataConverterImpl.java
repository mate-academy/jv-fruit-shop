package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SPLIT = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(SPLIT);
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid string CSV: " + line);
            }
            String operationCode = parts[0];
            String fruit = parts[1];
            Integer quantity = Integer.parseInt(parts[2]);
            Operation operation = Operation.fromCode(operationCode);
            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
