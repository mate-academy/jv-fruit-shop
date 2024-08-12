package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

import static core.basesyntax.model.FruitTransaction.convertFromCode;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int LINES_TO_SKIP = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null || inputReport.isEmpty()) {
            throw new IllegalArgumentException("Input report cannot be null or empty");
        }

        return inputReport.stream()
                .skip(LINES_TO_SKIP)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid input line: " + line);
        }

        FruitTransaction.Operation operation = convertFromCode(parts[OPERATION_INDEX]);
        String product = parts[PRODUCT_INDEX];
        int quantity;

        try {
            quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format for quantity: "
                    + parts[QUANTITY_INDEX], e);
        }
        return new FruitTransaction(operation, product, quantity);
    }
}
