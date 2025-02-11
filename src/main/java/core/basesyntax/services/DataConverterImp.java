package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public class DataConverterImp implements DataConverter {
    private static final String COMMA = ",";
    private static final int ZERO_POSITION = 0;
    private static final int FIRST_POSITION = 1;
    private static final int SECOND_POSITION = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .map(line -> {
                    String[] parts = line.split(COMMA);
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .fromString(parts[ZERO_POSITION].trim().toLowerCase());
                    String fruit = parts[FIRST_POSITION].trim();
                    int quantity = Integer.parseInt(parts[SECOND_POSITION].trim());
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .toList();
    }
}

