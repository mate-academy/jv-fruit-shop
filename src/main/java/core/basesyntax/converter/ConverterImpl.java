package core.basesyntax.converter;

import core.basesyntax.ItemTransaction;
import core.basesyntax.data.Operation;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterImpl implements Converter {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_ITEM = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<ItemTransaction> convert(List<String> strings) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("Input data is null");
        }
        return strings.stream()
                .skip(1)
                .map(this::toItemTransaction)
                .collect(Collectors.toList());
    }

    private ItemTransaction toItemTransaction(String string) {
        String[] partString = string.split(",");

        if (partString.length != 3) {
            throw new IllegalArgumentException("Invalid input data " + string);
        }

        try {
            Operation operation = Operation.fromString(partString[INDEX_TYPE_OPERATION].trim());
            String item = partString[INDEX_ITEM].trim();
            int quantity = Integer.parseInt(partString[INDEX_QUANTITY].trim());
            return new ItemTransaction(operation, item, quantity);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid input data " + string, e);
        }
    }
}
