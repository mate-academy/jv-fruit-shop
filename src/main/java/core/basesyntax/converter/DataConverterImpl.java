package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int EXPECTED_PARTS_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {

        if (inputReport == null || inputReport.isEmpty()) {
            throw new IllegalArgumentException("Input report cannot be null or empty");
        }

        return inputReport.stream()
                .skip(1)
                .map(this::parseLine)
                .toList();

    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(DELIMITER);

        if (parts.length != EXPECTED_PARTS_COUNT) {
            throw new IllegalArgumentException("Invalid data format in line: " + line);
        }

        try {
            return new FruitTransaction(
                    parts[OPERATION_INDEX],
                    parts[FRUIT_NAME_INDEX],
                    parts[QUANTITY_INDEX]);

        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity format in line: " + line, e);
        }
    }
}
