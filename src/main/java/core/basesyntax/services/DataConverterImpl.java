package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream().skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    FruitTransaction.Operation operation
                            = FruitTransaction.Operation.getByCode(parts[0].trim());
                    String fruit = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    return new FruitTransaction(operation, fruit, quantity);
                }).collect(Collectors.toList());
    }
}

