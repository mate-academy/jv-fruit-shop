package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::parseLine)
                .toList();
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(SEPARATOR);
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
        String fruit = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
