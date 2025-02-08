package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.Operation;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImp implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    Operation operation = Operation.valueOf(parts[0].toUpperCase());
                    String fruit = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
