package core.basesyntax.service.parser;

import static core.basesyntax.service.reportgenerator.ReportGeneratorImpl.DELIMITER;

import core.basesyntax.service.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParseFruitDataImpl implements ParseFruitData {
    private static final int REQUIRED_COLUMNS = 3;
    private static final String INVALID_FORMAT_MSG = "Invalid data format in line: ";
    private static final String INVALID_QUANTITY_MSG = "Invalid quantity in line: ";

    @Override
    public List<FruitTransaction> parseData(List<String> fileInput) {
        if (fileInput == null || fileInput.isEmpty()) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        List<String> dataLines = fileInput.subList(1, fileInput.size());

        return dataLines.stream()
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        try {
            String[] parts = line.split(DELIMITER);
            validateLineParts(parts, line);

            String operationCode = parts[0];
            String fruit = parts[1];
            int quantity = parseQuantity(parts[2], line);

            return new FruitTransaction(operationCode, fruit, quantity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to parse line: " + line, e);
        }
    }

    private void validateLineParts(String[] parts, String line) {
        if (parts.length != REQUIRED_COLUMNS) {
            throw new IllegalArgumentException(INVALID_FORMAT_MSG + line
                    + ". Expected " + REQUIRED_COLUMNS + " columns");
        }
    }

    private int parseQuantity(String quantityStr, String line) {
        try {
            return Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_QUANTITY_MSG + line, e);
        }
    }
}
