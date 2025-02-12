package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImp implements DataConverter {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .map(line -> {
                    String[] parts = line.split(COMMA);

                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .fromString(parts[OPERATION_INDEX].trim().toLowerCase());
                    String fruit = parts[FRUIT_INDEX].trim();

                    int quantity;
                    try {
                        quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid quantity format in line: "
                                + line, e);
                    }

                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
