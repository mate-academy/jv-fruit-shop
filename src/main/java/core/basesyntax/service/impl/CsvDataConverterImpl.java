package core.basesyntax.service.impl;

import static core.basesyntax.util.CsvUtil.CSV_SEPARATOR;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvDataConverterImpl implements DataConverter {
    public static final int TYPE_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    private static FruitTransaction convertToTransaction(String line) {
        if (line == null || line.isEmpty() || line.split(CSV_SEPARATOR).length != 3) {
            return null;
        }

        String[] parts = line.split(CSV_SEPARATOR);
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .fromCode(parts[TYPE_INDEX]);
        String fruit = parts[FRUIT_INDEX];
        Integer quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());

        return new FruitTransaction(operation, fruit, quantity);
    }

    @Override
    public List<FruitTransaction> convertToTransactionList(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("lines cannot be null or empty");
        }
        return lines.subList(1, lines.size()).stream()
                .map(CsvDataConverterImpl::convertToTransaction)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
