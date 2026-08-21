package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .getByCode(parts[0]);
                    String fruit = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
