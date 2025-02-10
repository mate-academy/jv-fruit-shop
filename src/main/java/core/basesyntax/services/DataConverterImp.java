package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImp implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .fromString(parts[0].trim().toLowerCase());
                    String fruit = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}

