package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream().skip(1).map(this::parseLine).collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(",");
        FruitTransaction.Operation operation = FruitTransaction.Operation.valueOf(parts[0].toUpperCase());
        String fruit = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
