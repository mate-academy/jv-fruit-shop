package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransactions(List<String> reports) {
        if (reports == null) {
            throw new IllegalArgumentException("Reports must not be null");
        }
        return reports.stream()
                .map(str -> {
                    String[] parts = str.split(",");
                    if (parts.length < 3) {
                        throw new IllegalArgumentException("Not enough data to create transaction");
                    }
                    FruitTransaction.Operation op = FruitTransaction.Operation.fromCode(parts[0]);
                    String fruit = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    return FruitTransaction.of(op, fruit, quantity);
                })
                .toList();
    }
}
