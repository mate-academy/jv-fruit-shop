package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public class DataConverterImp implements DataConverter {
    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .map(line -> {
                    String[] parts = line.split(COMMA);
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .fromString(parts[ZERO].trim().toLowerCase());
                    String fruit = parts[ONE].trim();
                    int quantity = Integer.parseInt(parts[TWO].trim());
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .toList();
    }
}

