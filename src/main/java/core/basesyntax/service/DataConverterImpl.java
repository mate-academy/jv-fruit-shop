package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            return List.of();
        }
        return lines.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    FruitTransaction.Operation operation = FruitTransaction
                            .Operation.fromCode(parts[0]);
                    String fruit = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2]);
                    if (quantity < 0) {
                        throw new IllegalArgumentException("The quantity cannot be negative: " + quantity);
                    }
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
