package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int LIMIT = -1;
    private static final String SPLIT = ",";
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int ZERO_VALUE = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int HEAD_FILE = 1;
    private static final int INDEX_NUMBER = 2;
    private static final int ARRAYS_LENGTH = 3;
    private static final String TITLE_FILE = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convertAll(List<String> line) {
        if (line == null) {
            throw new RuntimeException("Input lines list must not be null.");
        }
        if (line.isEmpty()) {
            throw new RuntimeException("Input lines list must "
                    +
                    "not be empty (no CSV lines to process)");
        }
        if (!line.get(INDEX_OPERATION_TYPE).equals(TITLE_FILE)) {
            throw new RuntimeException("File header does not match the desired format.");
        }
        return line.stream()
                .skip(HEAD_FILE)
                .map(this::lineSplit)
                .filter(strings -> {
                    if (strings.length != ARRAYS_LENGTH) {
                        throw new RuntimeException("This number of tokens "
                                +
                                "does not correspond to the correct result");
                    }
                    return true;
                })
                .map(f -> new FruitTransaction(
                        Operation.getOperationType(f[INDEX_OPERATION_TYPE].toLowerCase()),
                        validateEmptyAndNull(f[INDEX_FRUIT]), validateNumber(f[INDEX_NUMBER])))
                .collect(Collectors.toList());
    }

    private String[] lineSplit(String line) {
        return Arrays.stream(line.split(SPLIT, LIMIT))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private String validateEmptyAndNull(String fruit) {
        if (fruit == null) {
            throw new RuntimeException("fruit cannot be null");
        }
        if (fruit.isBlank()) {
            throw new RuntimeException("fruit cannot be empty");
        }
        return fruit;
    }

    private int validateNumber(String number) {
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (RuntimeException e) {
            throw new RuntimeException("Incorrect number format: " + number, e);
        }
        if (value < ZERO_VALUE) {
            throw new RuntimeException("Error number should not be negative");
        }
        return value;
    }
}
